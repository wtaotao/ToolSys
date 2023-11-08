package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * 买卖股票的最佳时机
 * @author Jesse
 *
 */
public class RTest121 {

	public static void main(String[] args) {
		int[] nums = {7,1,5,3,6,4};
		Print.stringOut("The max profit is:" + maxProfit(nums));
	}
	/**
	 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
	 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
	 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
	 * @param prices
	 * @return
	 */
    public static int maxProfit(int[] prices) {
        int[] temp = new int[prices.length-1];
        for (int i=0; i<temp.length; i++) {
        	temp[i] = prices[i+1]-prices[i];
        }
        int sum = 0, max = 0;
        boolean flag = false;
        for (int j=0; j<temp.length; j++) {
        	if (!flag) {
        		if (temp[j] > 0) {
        			sum = sum + temp[j];
        			if (sum > max) max = sum;
        			flag = true;
        		}
        	} else {
        		sum = sum +temp[j];
        		if (sum <= 0) {
        			sum = 0;
        			flag = false;
        		} else {
        			if (sum > max) max = sum;
        		}
        	}
        }
    	return max;
    }
}
