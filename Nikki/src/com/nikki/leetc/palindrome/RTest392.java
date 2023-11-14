package com.nikki.leetc.palindrome;

import com.nikki.out.Print;

/**
 * 判断子序列
 * @author Jesse
 *
 */
public class RTest392 {

	public static void main(String[] args) {
		String s = "abc", t = "ahbgdc";
		Print.stringOut("Is subSequence？" + isSubsequence(s, t));

	}
	/**
	 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
	 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
	 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
	 * 进阶：
	 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
	 * 示例 1：
	 * 输入：s = "abc", t = "ahbgdc"
	 * 输出：true
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isSubsequence(String s, String t) {
	    boolean isSub = false;
		if (s == null || t == null || s.length() > t.length()) return isSub;
		int i = 0, j = 0;
		while(i < s.length() && j < t.length()) {
		    if (s.charAt(i) == t.charAt(j)) {
		        i++;
		        if (i < s.length()) {
		            j++;
		        }
		    } else {
		        j++;
		    }
		}
		if (i == s.length() && j < t.length()) isSub = true; 
	    return isSub;
	}
}
