package com.hk.rest.service;

import com.hk.rest.model.Cricketer;
import com.hk.rest.service.exception.CricketerNotFoundException;

public interface ICricketerService {
	
	public Cricketer insertCricketer(Cricketer cricketer);
	public Cricketer updateCricketer(Cricketer cricketer) throws CricketerNotFoundException;
	public void      deleteCricketer(Integer id) throws CricketerNotFoundException;
	public Cricketer getCricketer(Integer id) throws CricketerNotFoundException;

}
