package com.nikki.leetc;
/**
 * 买卖股票的最佳时机 II
 * @author Jesse
 *
 */
public class RTest122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
	 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有一股股票。
	 * 你也可以先购买，然后在同一天出售。
	 * 返回 你能获得的最大利润 。
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
        int[] temp = new int[prices.length-1];
        for (int i=0; i<temp.length; i++) {
        	temp[i] = prices[i+1]-prices[i];
        }
        int sum = 0;
        boolean flag = false;
        for (int j=0; j<temp.length; j++) {
        	if (temp[j] > 0) sum = sum + temp[j];
        }
    	return sum;
    }
}
