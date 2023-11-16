package com.nikki.leetc.hash;

import java.util.HashMap;

import com.nikki.out.Print;

/**
 * 有效的字母异位词
 * @author Jesse
 *
 */
public class RTest242 {

	public static void main(String[] args) {
		String s = "anagram", t = "nagaram";
		Print.stringOut("Is anagram?" + isAnagram(s, t));
	}
	/**
	 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
	 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
	 * 输入: s = "anagram", t = "nagaram"
	 * 输出: true
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isAnagram(String s, String t) {
		boolean isAnagram = false;
		//假定s和t均不为空
		if (s.length() != t.length()) {
		    return isAnagram;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
		    char c = s.charAt(i);
		    if (map.containsKey(c)) {
		        map.put(c, map.get(c)+1);
		    } else {
		        map.put(c, 1);
		    }
		}
		for (int i = 0; i < t.length(); i++) {
		    char c = t.charAt(i);
		    if (!map.containsKey(c)) {
		        isAnagram = false;
		        return isAnagram;
		    } else {
		        int value = map.get(c);
		        value = value - 1;
		        if (value == 0) {
		            map.remove(c);
		        } else {
		            map.put(c, value);
		        }
		    }
		}
		if (map.isEmpty()) {
		    isAnagram = true;
		}
		return isAnagram;
	}
}
