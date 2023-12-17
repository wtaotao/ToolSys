package com.nikki.leetc.muldynamicplan;

import com.nikki.out.Print;

/**
 *交错字符串
 *@author:Jesse
 *@version:2023年12月13日下午10:53:54
**/
public class RTest97 {

	public static void main(String[] args) {
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
		RTest97 test = new RTest97();
		Print.stringOut("Is interleave?" + test.isInterleave(s1, s2, s3));
	}
	/**
	 * 给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2交错组成的。
	 * 两个字符串s和t交错的定义与过程如下，其中每个字符串都会被分割成若干非空子字符串：
	 * s = s1 + s2 + ... + sn
	 * t = t1 + t2 + ... + tm
	 * |n - m| <= 1
	 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
	 * 注意：a + b意味着字符串a和b连接。
	 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出：true
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
    public boolean isInterleave1(String s1, String s2, String s3) {
        //思路：S3的每个字符跟S1，S2对比，相等的情况下下一个
        //s3为空时，只有s1,s2同时为空（空字符串也认为不一样）才会true，否则为false
        if (s3 == null) {
            if (s1 == null && s2 == null) {
                return true;
            } else {
                return false;
            }
        }
        //快速判断，缩小范围：s3非空时，s1或者s2为空则另外一个串需与s3完全一样
        if (s1 == null || s2 == null) {
            if (s3.equals(s1) || s3.equals(s2)) {
                return true;
            } else {
                return false;
            }
        }
        //三个串均不为空时，s1，s2的长度之和不等于s3，则返回false
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }
        int i = 0, j = 0, k = 0;
        //s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        //如果当前两边都含一样的字符，其实涉及到顺序问题，否则可能剩下的字符串因顺序不同而不匹配
        while (k < s3.length()) {
            if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
                i++;
                k++;
            } else if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
                j++;
                k++;
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }
}
