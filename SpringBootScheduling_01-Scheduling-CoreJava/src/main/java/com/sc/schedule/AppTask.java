package com.sc.schedule;

import java.util.Date;
import java.util.TimerTask;

public class AppTask extends TimerTask {

	@Override
	public void run() {
		System.err.println("Schedue :: " + new Date());
	}

}
