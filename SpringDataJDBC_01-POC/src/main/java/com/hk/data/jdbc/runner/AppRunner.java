package com.hk.data.jdbc.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hk.data.jdbc.service.IplTeamMgmtService;

@Component
public class AppRunner implements CommandLineRunner {
	
	@Autowired
	private IplTeamMgmtService service;

	@Override
	public void run(String... args) throws Exception {
//		IplTeam team = new IplTeam(1004, "MI", "Hardik Pandya", "Akash Ambani", 5, true);
//		System.err.println("Team is registered as '" + service.registerIplTeam(team) + "'");
//		IplTeam team1 = new IplTeam(1005, "RR", "Snaju Samson", "Manoj Badale", 1, true);
//		System.err.println("Team is registered as '" + service.registerIplTeam(team1) + "'");
//		IplTeam team2 = new IplTeam(1006, "DC", "Rishab Pant", "JMR group&JSW Sports", 0, true);
//		System.err.println("Team is registered as '" + service.registerIplTeam(team2) + "'");
//		IplTeam team3 = new IplTeam(1007, "KKR", "Shreyas Iyer", "Sharukh Khan", 2, true);
//		System.err.println("Team is registered as '" + service.registerIplTeam(team3) + "'");
//		IplTeam team4 = new IplTeam(1008, "PK", "Shikhar Dhawan", "Preethi Jintha", 0, true);
//		System.err.println("Team is registered as '" + service.registerIplTeam(team4) + "'");
//		IplTeam team5 = new IplTeam(1009, "GT", "Shubman Gill", "CVC Capital Partners", 1, true);
//		System.err.println("Team is registered as '" + service.registerIplTeam(team5) + "'");
//		IplTeam team6 = new IplTeam(1010, "LSG", "K L Rahul", "Sanjeev Goenka", 0, true);
//		System.err.println("Team is registered as '" + service.registerIplTeam(team6) + "'");
		
//		service.getAllIplTeams().forEach(System.err::println);
		
		service.IplTitleWinners().forEach(System.err::println);
	}

}
