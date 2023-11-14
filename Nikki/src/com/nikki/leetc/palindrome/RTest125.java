package com.nikki.leetc.palindrome;

import com.nikki.out.Print;

/**
 * 验证回文串
 * @author Jesse
 *
 */
public class RTest125 {

	public static void main(String[] args) {
//	    String s = "A man, a plan, a canal: Panama";
//	    String s = "race a car";
	    String s = "0P";
		Print.stringOut("isPalindrome ? " + isPalindrome(s));

	}
	/**
	 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
	 * 字母和数字都属于字母数字字符。
	 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
	 * 示例 1：
	 * 输入: s = "A man, a plan, a canal: Panama"
	 * 输出：true
	 * 解释："amanaplanacanalpanama" 是回文串。
	 * 示例 2：
	 * 输入：s = "race a car"
	 * 输出：false
	 * 解释："raceacar" 不是回文串。
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		boolean isPalindrome = false;
		if (s == null || s.length() == 0) return isPalindrome;
		int start = 0, end = s.length()-1;
		s = s.toLowerCase();
		while (start < end) {
		    char startC = s.charAt(start), endC = s.charAt(end);
		    if (!(startC >= 'a' && startC <= 'z') && !(startC >= '0' && startC <= '9')) {
		        start++;
		        continue;
		    }
		    if (!(endC >= 'a' && endC <= 'z') && !(endC >= 0 && endC <= 9)) {
		        end--;
		        continue;
		    }
		    if (startC == endC) {
		        start++;
		        end--;
		    } else {
		        isPalindrome = false;
		        break;
		    }
		}
		if (start >= end) isPalindrome = true;
	    return isPalindrome;
	}
}
