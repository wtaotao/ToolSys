package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * 找出字符串中第一个匹配项的下标
 * @author Jesse
 *
 */
public class RTest28 {

	public static void main(String[] args) {
		String haystack = "fkksbbjjsbb";
		String needle = "sbb";
		Print.stringOut("This start index is:" + strStr(haystack, needle));
	}
	/**
	 * 给你两个字符串haystack和needle，请你在haystack字符串中找出needle字符串的第一个匹配项的下标（下标从0开始）。
	 * 如果needle不是haystack的一部分，则返回-1。
	 * @param haystack
	 * @param needle
	 * @return
	 */
    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        //转换成字符数组
        char[] s = haystack.toCharArray(), p = needle.toCharArray();
        // 枚举原串的「发起点」
        for (int i = 0; i <= n - m; i++) {
            // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
            int a = i, b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (b == m) return i;
        }
        return -1;
    }
}
