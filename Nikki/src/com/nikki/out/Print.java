package com.nikki.out;

import java.util.List;

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
	public static void arrayOut(char[] a) {
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
	
    public static void printLists (List<List<Integer>> lists) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < lists.size(); j++) {
            List<Integer> list = lists.get(j);
            if (j == 0) {
                sb.append("[");
            }
            if (j > 0) {
                sb.append(",");
            }
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    sb.append("[").append(list.get(i));
                } else {
                    sb.append(",").append(list.get(i));
                }
                if (i == list.size()-1) {
                    sb.append("]");
                }
            }
            if (j == lists.size()-1) {
                sb.append("]");
            }
        }
        stringOut(sb.toString());     
    }
}
