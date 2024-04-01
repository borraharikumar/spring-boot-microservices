package com.sc;

import java.util.Date;
import java.util.Timer;

import com.sc.schedule.AppTask;

public class TestRunner {
	
	public static void main(String[] args) {
		System.err.println("Application start :: " + new Date());
		Timer timer = new Timer();
		//timer.schedule(new AppTask(), new Date(2024-1900, 01, 25, 07, 15, 30)); // Point of time
		//timer.schedule(new AppTask(), 5000); // Period of time
		//timer.schedule(new AppTask(), new Date(2024-1900, 01, 25, 07, 15, 30), 5000); // Period of time
		timer.schedule(new AppTask(), 4000, 3000);
	}

}
