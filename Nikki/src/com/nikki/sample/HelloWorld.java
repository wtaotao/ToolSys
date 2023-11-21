package com.nikki.sample;

import com.nikki.out.Print;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Hello World!");
		
		StringBuffer sb1 = new StringBuffer("ABCD");
		StringBuilder sb2 = new StringBuilder("EFG");
		Print.stringOut(sb1.reverse().toString());
		Print.stringOut(sb2.reverse().toString());
	}

}
