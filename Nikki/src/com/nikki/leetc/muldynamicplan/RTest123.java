package com.nikki.leetc.muldynamicplan;

import com.nikki.out.Print;

/**
 *买卖股票的最佳时机 III
 *@author:Jesse
 *@version:2023年12月13日下午10:57:22
**/
public class RTest123 {

	public static void main(String[] args) {
//		int[] prices = {3,3,5,0,0,3,1,4};
		int[] prices = {1,2,4,2,5,7,2,4,9,0};
        RTest123 test = new RTest123();
        Print.stringOut("The max profit is:" + test.maxProfit1(prices));
	}
	/**
	 * 给定一个数组，它的第i个元素是一支给定的股票在第i天的价格。
	 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
	 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
	 * 输入：prices = [3,3,5,0,0,3,1,4]--0,2,-5,0,3,-2,3
     * 输出：6
     * 解释：在第4天（股票价格 = 0）的时候买入，在第6天（股票价格 = 3）的时候卖出，这笔交易所能获得利润= 3-0 = 3 。
     * 随后，在第7天（股票价格 = 1）的时候买入，在第8天（股票价格 = 4）的时候卖出，这笔交易所能获得利润= 4-1 = 3 。
	 * @param prices
	 * @return
	 */
	//prices =[1,2,4,2,5,7,2,4,9,0],預期結果13
    public int maxProfit1(int[] prices) {
        //算出隔天的价格差，找出两个连续最大和的子集;是否存在跨负值且和比前面逻辑更大的子集？？？--本方式实现不了
        if (prices == null || prices.length < 2) return 0;
        int max = 0;
        int[] profits = new int[prices.length-1]; 
        for (int i = 0; i < profits.length; i++) {
            profits[i] = prices[i+1] - prices[i];
        }
        //找出总和前二大的连续正值区间
        int first = 0, second = 0, sum = 0;
        for (int i = 0; i < profits.length; i++) {
            if (profits[i] >= 0) {
                sum += profits[i];
            }
            //区间结束：遇到了负值或者数组结尾
            if (profits[i] < 0 || i == profits.length-1) {
                if (sum > first) {
                    second = first;
                    first = sum;
                } else {
                    if (sum > second) {
                        second = sum;
                    }
                }
                sum = 0;
            }
        }
        max = first + second;
        return max;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
        	//只进行过一次买操作
            buy1 = Math.max(buy1, -prices[i]);
            //进行了一次买操作和一次卖操作，即完成了一笔交易
            sell1 = Math.max(sell1, buy1 + prices[i]);
            //在完成了一笔交易的前提下，进行了第二次买操作
            buy2 = Math.max(buy2, sell1 - prices[i]);
            //完成了全部两笔交易
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
