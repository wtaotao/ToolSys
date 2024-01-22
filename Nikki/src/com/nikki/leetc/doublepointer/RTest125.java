package com.nikki.leetc.doublepointer;

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
	 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个回文串。
	 * 字母和数字都属于字母数字字符。
	 * 给你一个字符串s，如果它是回文串，返回true；否则，返回false。
	 * 示例 1：
	 * 输入: s = "A man, a plan, a canal: Panama"
	 * 输出：true
	 * 解释："amanaplanacanalpanama"是回文串。
	 * 示例 2：
	 * 输入：s = "race a car"
	 * 输出：false
	 * 解释："raceacar"不是回文串。
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		boolean isPalindrome = false;
		//若字符串为空则非回文串
		if (s == null || s.length() == 0) return isPalindrome;
		int start = 0, end = s.length()-1;
		s = s.toLowerCase();
		//从收尾相向搜索比较
		while (start < end) {
		    //获取首尾指针指向的字符
		    char startC = s.charAt(start), endC = s.charAt(end);
		    //若既非字符也非数字，首指针+1
		    if (!(startC >= 'a' && startC <= 'z') && !(startC >= '0' && startC <= '9')) {
		        start++;
		        continue;
		    }
		    //若既非字符也非数字，尾指针-1
		    if (!(endC >= 'a' && endC <= 'z') && !(endC >= 0 && endC <= 9)) {
		        end--;
		        continue;
		    }
		    //首尾指向的字符相同则同时相向移至下一个字符比较
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
