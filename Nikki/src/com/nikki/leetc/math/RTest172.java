package com.nikki.leetc.math;

import com.nikki.out.Print;

/**
 *阶乘后的零
 *@author:Jesse
 *@version:2023年12月12日下午11:42:54
**/
public class RTest172 {

	public static void main(String[] args) {
	    int n = 3;
		Print.stringOut("The trail zero number is:" + trailingZeroes(n));
	}
	/**
	 * 给定一个整数n，返回n!结果中尾随零的数量。
	 * 提示n! = n*(n - 1)*(n - 2)* ... *3*2*1
	 * 输入：n = 3
     * 输出：0
     * 解释：3! = 6 ，不含尾随0
	 * @param n
	 * @return
	 */
    public static int trailingZeroes(int n) {
        //思路：2*5=10，偶数均可分解出2，因此0的数目就是5的个数
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
