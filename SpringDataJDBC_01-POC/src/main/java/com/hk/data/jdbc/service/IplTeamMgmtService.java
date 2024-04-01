package com.hk.data.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.data.jdbc.model.IplTeam;
import com.hk.data.jdbc.repository.IplTeamRepo;

@Service
public class IplTeamMgmtService {
	
	@Autowired
	private IplTeamRepo repository;
	
	public IplTeam registerIplTeam(IplTeam iplTeam) {
		return repository.save(iplTeam);
	}
	
	public Iterable<IplTeam> getAllIplTeams() {
		return repository.findAll();
	}
	
	public List<IplTeam> IplTitleWinners() {
		return repository.getIplWinnerTeams();
	}

}
