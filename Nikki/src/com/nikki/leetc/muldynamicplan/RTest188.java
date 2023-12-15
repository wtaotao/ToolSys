package com.nikki.leetc.muldynamicplan;

import java.util.Arrays;

/**
 *买卖股票的最佳时机 IV
 *@author:Jesse
 *@version:2023年12月13日下午10:58:35
**/
public class RTest188 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个整数数组prices和一个整数k，其中prices[i]是某支给定的股票在第i天的价格。
	 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成k笔交易。也就是说，你最多可以买k次，卖k次。
	 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
	 * 输入：k = 2, prices = [2,4,1]
     * 输出：2
     * 解释：在第1天(股票价格 = 2)的时候买入，在第2天(股票价格 = 4)的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
	 * @param k
	 * @param prices
	 * @return
	 */
	//[1,2,4,2,5,7,2,4,9,0]/2 預期13
    public int maxProfit1(int k, int[] prices) {
        //算出隔天的价格差，找出k连续最大和的子集;是否存在跨负值且和比前面逻辑更大的子集？？？
        if (prices == null || prices.length < 2) return 0;
        int max = 0;
        int[] profits = new int[prices.length-1]; 
        for (int i = 0; i < profits.length; i++) {
            profits[i] = prices[i+1] - prices[i];
        }
        //找出总和前二大的连续正值区间
        int[] kst = new int[k];
        int sum = 0;
        for (int i = 0; i < profits.length; i++) {
            if (profits[i] >= 0) {
                sum += profits[i];
            }
            //区间结束：遇到了负值或者数组结尾
            if (profits[i] < 0 || i == profits.length-1) {
                boolean isUpdating = false;
                int temp = 0;
                for (int j = 0; j < kst.length; j++) {
                    if (!isUpdating && sum > kst[j]) {
                        temp = kst[j];
                        kst[j] = sum;
                        isUpdating = true;
                        continue;
                    }
                    if (isUpdating) {
                        int ex = kst[j];
                        kst[j] = temp;
                        temp = ex;
                    }
                }
                sum = 0;
            }
        }
        for (int i: kst) {
            max += i;
        }
        return max;
    }
    public int maxProfit(int k, int[] prices) {
        //价格为空，最大利润0
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        //初始化成最小值
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);   
            }
        }

        return Arrays.stream(sell).max().getAsInt();
    }
}
