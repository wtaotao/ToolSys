package com.nikki.leetc.slidingwin;

import java.util.HashMap;

import com.nikki.out.Print;

/**
 * 最小覆盖子串
 * @author Jesse
 *
 */
public class RTest76 {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC", t = "ABC";
		Print.stringOut(minWindow(s, t));
	}
	/**
	 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
	 * 注意：
	 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
	 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
	 * 输入：s = "ADOBECODEBANC", t = "ABC"
	 * 输出："BANC"
	 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
	 * @param s
	 * @param t
	 * @return
	 */
	public static String minWindow(String s, String t) {
	    StringBuffer subbuf = new StringBuffer();
	    HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
	    for (int i = 0; i < t.length(); i++) {
	        char c = t.charAt(i);
	        if (charMap.containsKey(c)) {
	            charMap.put(c, charMap.get(c)+1);
	        } else {
	            charMap.put(c, 1);
	        }
	    }
	    int start = 0, end = 0;
	    boolean isCounting = false;
	    while (end < s.length()) {
	        char key = s.charAt(end);
	        if (charMap.containsKey(key)) {
	            if(!isCounting) {
	                start = end;
	                isCounting = true;
	            }
	            int count = charMap.get(key) - 1;
	            if (count == 0) {
	                charMap.remove(key);
	            } else {
	                charMap.put(key, count);
	            }
	        }
	        if (charMap.isEmpty()) {
	            break;
	        }
	        end++;
	    }
	    if (charMap.isEmpty()) {
	       subbuf.append(s.substring(start, end+1)) ;
	    } 
		return subbuf.toString();
	}
}
