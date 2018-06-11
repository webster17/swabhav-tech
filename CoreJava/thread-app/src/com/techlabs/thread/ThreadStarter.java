package com.techlabs.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ThreadStarter implements Runnable {

	@Override
	public void run() {
		DateTimeFormatter dtf = DateTimeFormatter
				.ofPattern("yyyy/MM/dd HH:mm:ss");
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
		}
	}
}
