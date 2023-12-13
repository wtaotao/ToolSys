package com.nikki.sample;

import java.util.LinkedList;

import com.nikki.out.Print;

public class HelloWorld {

	public static void main(String[] args) {
	    HelloWorld ins = new HelloWorld();
		System.out.println("Hello World!");
		
		ins.testListAdd();
	}
	//测试链表增加null
	private void testListAdd() {
	    LinkedList<Integer> list = new LinkedList<Integer>();
	    list.add(1);
	    list.add(2);
	    list.add(null);
	    list.add(4);
	    for(Integer i: list) {
	        Print.stringOut("value:" + i);
	    }
	}
    //测试字符串反转
	private void testSBReverse() {
	    StringBuffer sb1 = new StringBuffer("ABCD");
	    StringBuilder sb2 = new StringBuilder("EFG");
	    Print.stringOut(sb1.reverse().toString());
	    Print.stringOut(sb2.reverse().toString());
	}
}
