package com.nikki.leetc.hash;

import java.util.HashMap;

import com.nikki.out.Print;

/**
 * 单词规律
 * @author Jesse
 *
 */
public class RTest290 {

	public static void main(String[] args) {
		String pattern = "abba", s = "dog cat cat dog";
		Print.stringOut("Is match?" + wordPattern(pattern, s));
	}
	/**
	 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
	 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
	 * 输入: pattern = "abba", s = "dog cat cat dog"
	 * 输出: true
	 * @param pattern
	 * @param s
	 * @return
	 */
	public static boolean wordPattern(String pattern, String s) {
	    boolean flag = false;
	    String[] words = s.split(" ");
	    //假定pattern和s都非空
	    if (pattern.length() != words.length) {
	        flag = false;
	        return flag;
	    }
	    HashMap<Character, String> map = new HashMap<Character, String>();
	    int i = 1;
	    for (; i < pattern.length(); i++) {
	        char c = pattern.charAt(i);
	        if (map.containsKey(c)) {
	            if (!words[i].equals(map.get(c))) {
	                flag = false;
	                return flag;
	            } 
	        } else {
	            map.put(c, words[i]);
	        }
	    }
	    if (i == pattern.length()) {
	        flag = true;
	    }
		return flag;
	}
}
