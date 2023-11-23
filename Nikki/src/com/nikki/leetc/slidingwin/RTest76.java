package com.nikki.leetc.slidingwin;

import java.util.HashMap;
import java.util.Map;

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
	//错误
	public static String minWindow1(String s, String t) {
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
	  public static String minWindow(String s, String t) {
	        Map<Character, Integer> need = new HashMap<Character, Integer>();
	        Map<Character, Integer> window = new HashMap<Character, Integer>();
	        for (int i = 0; i < t.length(); i++) {
	            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
	        }
	        int right = 0, left = 0;
	        int valid = 0;
	        int start = 0, minLen = Integer.MAX_VALUE;
	        while (right < s.length()) {
	            char cur = s.charAt(right);
	            right++;
	            // 进行窗口数据一系列更新
	            if (need.containsKey(cur)) {
	                Integer total = window.getOrDefault(cur, 0);
	                window.put(cur, total + 1);
	                if (window.get(cur).equals(need.get(cur))) {
	                    valid++;
	                }
	            }
	            while (need.size() == valid) {
	                if (right - left < minLen) {
	                    start = left;
	                    minLen = right - left;
	                }
	                // d 是将移除窗口的字符串
	                char d = s.charAt(left);
	                // 左边移动窗口
	                left++;
	                // 进行窗口内数据当一系列更新
	                if (window.containsKey(d)) {
	                    if (window.get(d).equals(need.get(d))) {
	                        valid--;
	                    }
	                    window.put(d, window.get(d) - 1);
	                }
	            }
	        }
	        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
	    }
}
