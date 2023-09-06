package com.nikki.pattern;

public class DoubleCheckSingleton {
	
	private static volatile DoubleCheckSingleton instance;
	
	private void DoubleCheckSingleton() {
		
	}
	
	public static DoubleCheckSingleton getIntance() {
		
		if(instance == null) {
			synchronized(DoubleCheckSingleton.class) {
				if(instance == null) {
					instance = new DoubleCheckSingleton();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
