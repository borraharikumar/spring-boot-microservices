package com.hk.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.rest.exception.TouristNotFoundException;
import com.hk.rest.model.Tourist;
import com.hk.rest.repository.ITouristRepository;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService {
	
	@Autowired
	private ITouristRepository repository;

	@Override
	public Tourist insertTourist(Tourist tourist) {
		return repository.save(tourist);
	}

	@Override
	public Tourist selectTourist(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public Tourist updateTourist(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> optional = repository.findById(tourist.getId());
		if(optional.isPresent()) {
			return repository.save(tourist);
		} else {
			throw new TouristNotFoundException("Tourist not found with id '" + tourist.getId() + "'");
		}
	}

	@Override
	public void deleteTourist(Integer id) throws TouristNotFoundException {
		Optional<Tourist> optional = repository.findById(id);
		if(optional.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new TouristNotFoundException("Tourist not found with id '" + id + "'");
		}
	}

	@Override
	public List<Tourist> selectAllTourists() {
		return repository.findAll().stream().sorted((t1, t2)->t1.getName().compareTo(t2.getName())).toList();
	}

	@Override
	public Tourist updateTouristAddress(Integer id, String address) throws TouristNotFoundException {
		Optional<Tourist> optional = repository.findById(id);
		if(optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setAddress(address);
			return repository.save(tourist);
		} else {
			throw new TouristNotFoundException("Tourist not found with id '" + id + "'");
		}
	}

}
