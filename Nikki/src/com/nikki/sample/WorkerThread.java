package com.nikki.sample;

public class WorkerThread extends Thread {
	private static int index = 0;
	
	public WorkerThread(int i) {
		index = i;
	}
	
	public void run() {
		Print.stringOut("WorkerThread run---" + index);
	}

}
