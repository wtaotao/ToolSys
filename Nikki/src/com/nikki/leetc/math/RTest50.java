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
    public static double myPow1(double x, int n) {
        //思路：递归,运行栈溢出
        if (n == 0) return 1.00000;
        return x*myPow1(x, n-1);
    }
    //幂值考虑正负
    public static double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
    //分解幂减少计算
    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        //偶数幂，则算半幂的平方；奇数则多乘一个x
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
