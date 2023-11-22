package com.nikki.leetc.slidingwin;

import java.util.HashMap;

import com.nikki.out.Print;

/**
 * 无重复字符的最长子串
 * @author Jesse
 *
 */
public class RTest3 {

	public static void main(String[] args) {
		String s = "abcabcbb";
		Print.stringOut("The longest number is:" + lengthOfLongestSubstring(s));
	}
	/**
	 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
	 * 输入: s = "abcabcbb"
	 * 输出: 3 
	 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring1(String s) {
	    if (s == null || s.length() == 0) return 0;
		int len = 0, subMax = 0;
		HashMap<Character, Integer> cmap = new HashMap<Character, Integer>();
		int i = 0, j = 0;
		while (i < s.length()) {
		    if (!cmap.containsKey(s.charAt(i))) {
		        cmap.put(s.charAt(i), i);
		    } else {
		        subMax = i-j;
		        if (len < subMax) {
		            len = subMax;
		        }
		        j = cmap.get(s.charAt(i)) + 1;
		        cmap.put(s.charAt(i), i);
		    }
		    i++;
		}
		return len;
	}
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
        
    }
}
