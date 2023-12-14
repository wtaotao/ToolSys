	package com.nikki.leetc.onedynamicplan;
/**
 *爬楼梯
 *@author:Jesse
 *@version:2023年12月12日下午11:53:07
**/
public class RTest70 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 假设你正在爬楼梯。需要n阶你才能到达楼顶。
	 * 每次你可以爬1或2个台阶。你有多少种不同的方法可以爬到楼顶呢？
	 * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 青蛙跳台阶问题： f(0)=1f(0)=1f(0)=1 , f(1)=1f(1)=1f(1)=1 , f(2)=2f(2)=2f(2)=2 
     * f(n)=f(n−1)+f(n−2)
	 * @param n
	 * @return
	 */
    public int climbStairs(int n) {
        //思路：
        int a = 1, b = 1, sum;
        for(int i = 0; i < n - 1; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
