package com.hk.data.jdbc.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.hk.data.jdbc.model.IplTeam;

public interface IplTeamRepo extends CrudRepository<IplTeam, Integer> {
	
	@Query("SELECT * FROM IPL_TEAMS WHERE TITLES <> 0")
	public List<IplTeam> getIplWinnerTeams();

}
