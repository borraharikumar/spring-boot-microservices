package com.hk.rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.rest.model.Cricketer;
import com.hk.rest.repository.CricketerRepository;
import com.hk.rest.service.exception.CricketerNotFoundException;

@Service
public class CricketerServiceImpl implements ICricketerService {
	
	@Autowired
	private CricketerRepository repository;

	@Override
	public Cricketer insertCricketer(Cricketer cricketer) {
		return repository.save(cricketer);
	}

	@Override
	public Cricketer updateCricketer(Cricketer cricketer) throws CricketerNotFoundException {
		Optional<Cricketer> opt = repository.findById(cricketer.getId());
		if(opt.isPresent()) {
			return repository.save(cricketer);
		} else {
			throw new CricketerNotFoundException("Cricketer not found with id '" + cricketer.getId() + "'");
		}
	}

	@Override
	public void deleteCricketer(Integer id) throws CricketerNotFoundException {
		Optional<Cricketer> opt = repository.findById(id);
		if(opt.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new CricketerNotFoundException("Cricketer not found with id '" + id + "'");
		}
	}

	@Override
	public Cricketer getCricketer(Integer id) throws CricketerNotFoundException {
		Optional<Cricketer> opt = repository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new CricketerNotFoundException("Cricketer not found with id '" + id + "'");
		}
	}

}
