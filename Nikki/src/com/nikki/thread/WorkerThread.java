package com.nikki.thread;

import com.nikki.out.Print;

public class WorkerThread extends Thread {
	private static int index = 0;
	
	public WorkerThread(int i) {
		index = i;
	}
	
	public void run() {
		Print.stringOut("WorkerThread run---" + index);
	}

}
