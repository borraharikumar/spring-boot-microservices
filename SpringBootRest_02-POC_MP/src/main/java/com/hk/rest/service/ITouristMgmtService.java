package com.hk.rest.service;

import java.util.List;

import com.hk.rest.exception.TouristNotFoundException;
import com.hk.rest.model.Tourist;

public interface ITouristMgmtService {
	
	public Tourist insertTourist(Tourist tourist);
	public Tourist selectTourist(Integer id);
	public Tourist updateTourist(Tourist tourist) throws TouristNotFoundException;
	public Tourist updateTouristAddress(Integer id, String address) throws TouristNotFoundException;
	public void    deleteTourist(Integer id) throws TouristNotFoundException;
	public List<Tourist> selectAllTourists();

}
