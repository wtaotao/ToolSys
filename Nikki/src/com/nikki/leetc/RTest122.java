package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * 买卖股票的最佳时机 II
 * @author Jesse Wang
 *
 */
public class RTest122 {

	public static void main(String[] args) {
	    int[] nums = {7,1,5,3,6,4};
	    Print.stringOut("The max profit is:" + maxProfit(nums));
	}
	/**
	 * 给你一个整数数组prices，其中prices[i]表示某支股票第i天的价格。
	 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有一股股票。
	 * 你也可以先购买，然后在同一天出售。
	 * 返回你能获得的最大利润。
	 * @param prices
	 * @return
	 */
    public static int maxProfit(int[] prices) {
        //计算记录隔天的利润
        int[] temp = new int[prices.length-1];
        for (int i=0; i<temp.length; i++) {
        	temp[i] = prices[i+1]-prices[i];
        }
        int sum = 0;
        //计算累计最大利润
        for (int j=0; j<temp.length; j++) {
        	if (temp[j] > 0) sum = sum + temp[j];
        }
    	return sum;
    }
}
