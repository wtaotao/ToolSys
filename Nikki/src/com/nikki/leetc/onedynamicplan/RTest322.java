package com.nikki.leetc.onedynamicplan;

import java.util.Arrays;

import com.nikki.out.Print;

/**
 *零钱兑换
 *@author:Jesse
 *@version:2023年12月13日下午9:52:15
**/
public class RTest322 {

	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;
		RTest322 test = new RTest322();
        Print.stringOut("The count is:" + test.coinChange(coins, amount));
	}
	/**
	 * 给你一个整数数组coins，表示不同面额的硬币；以及一个整数amount，表示总金额。
	 * 计算并返回可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
	 * 你可以认为每种硬币的数量是无限的。
	 * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3 
     * 解释：11 = 5 + 5 + 1
	 * @param coins
	 * @param amount
	 * @return
	 */
    public int coinChange(int[] coins, int amount) {
        //思路：硬币面额从大到小排序，总额尝试减最大的面额，为正则减；为负则换更小的.可能几个和大于一个面额的拼？？？
        if (coins == null || coins.length == 0 || amount <= 0) return -1;
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length-1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount = amount - coins[i];
                count++;
            }
            //已经找到硬币组合
            if (amount == 0) break;
        }
        //如果没找到组合，count赋值-1
        if (amount > 0) count = -1;
        return count;
    }
}
