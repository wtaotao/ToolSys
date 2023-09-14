package com.nikki.out;

public class Print {

	public static void arrayOut(int[] a) {
		// check if null or no element
		if (null == a || 0 == a.length) {
			System.out.println("");
			return;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a.length; i++) {
			sb.append(a[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
	
	public static void stringOut(String s) {
		System.out.println(s);
	}
}
