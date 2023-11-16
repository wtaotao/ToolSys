package com.nikki.leetc.hash;

import java.util.HashMap;

import com.nikki.out.Print;

/**
 *  同构字符串
 * @author Jesse
 *
 */
public class RTest205 {

	public static void main(String[] args) {
		String s = "egg", t = "add";
		Print.stringOut("Is isomorphic?" + isIsomorphic(s, t));
	}
	/**
	 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
	 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
	 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
	 * 输入：s = "egg", t = "add"
	 * 输出：true
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isIsomorphic(String s, String t) {
		boolean isIsomorphic = false;
		
		if (s == null || t == null) {
		    if (s == null && t == null) {
		        isIsomorphic = true;
		    } else {
		        isIsomorphic = false;
		    }
		    return isIsomorphic;		    
		}
		
		if (s.length() != t.length()) {
		    return false;
		}
		
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		int i = 0;
		for (; i < s.length(); i++) {
		    char c1 = s.charAt(i), c2;
		    if (map.containsKey(c1)) {
		        c2 = map.get(c1);
		        if (t.charAt(i) != c2) {
		            isIsomorphic = false;
		            break;
		        }
		    } else {
		        map.put(c1, t.charAt(i));
		    }
		}
		if (i == s.length()) {
		    isIsomorphic = true;
		}
		return isIsomorphic;
	}
}
