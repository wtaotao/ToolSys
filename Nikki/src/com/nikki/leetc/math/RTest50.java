package com.nikki.leetc.math;

import com.nikki.out.Print;

/**
 *Pow(x, n)
 *@author:Jesse
 *@version:2023年12月12日下午11:45:16
**/
public class RTest50 {

	public static void main(String[] args) {
		double x = 2.00000;
		int n = 10;
        Print.stringOut("The pow is:" + myPow(x, n));
	}
	/**
	 * 实现pow(x, n)，即计算x的整数n次幂函数（即，xn）。
	 * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
	 * @param x
	 * @param n
	 * @return
	 */
    public static double myPow(double x, int n) {
        //思路：递归
        if (n == 0) return 1.00000;
        return x*myPow(x, n-1);
    }
}
