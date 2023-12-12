package com.nikki.leetc.bitwise;
/**
 *二进制求和
 *@author:Jesse
 *@version:2023年12月11日下午11:38:09
**/
public class Rtest67 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
	 * 输入:a = "11", b = "1"
输出："100"
	 * @param a
	 * @param b
	 * @return
	 */
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
