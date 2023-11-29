package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * 买卖股票的最佳时机
 * @author Jesse Wang
 *
 */
public class RTest121 {

	public static void main(String[] args) {
		int[] nums = {7,1,5,3,6,4};
		Print.stringOut("The max profit is:" + maxProfit(nums));
	}
	/**
	 * 给定一个数组prices，它的第i个元素prices[i]表示一支给定股票第i天的价格。
	 * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。设计一个算法来计算你所能获取的最大利润。
	 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回0。
	 * @param prices
	 * @return
	 */
    public static int maxProfit(int[] prices) {
        int[] temp = new int[prices.length-1];
        //生成相隔两天的价格差价
        for (int i=0; i<temp.length; i++) {
        	temp[i] = prices[i+1]-prices[i];
        }
        int sum = 0, max = 0;
        //标记找到利润大于零的起点
        boolean flag = false;
        for (int j=0; j<temp.length; j++) {
            //重新开始计算时第一个节点
        	if (!flag) {
        		if (temp[j] > 0) {
        			sum = sum + temp[j];
        			if (sum > max) max = sum;
        			flag = true;
        		}
        	} else {
        		sum = sum +temp[j];
        		//区间利润非正，则可以放弃从新开始选择计算
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
