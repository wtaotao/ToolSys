package com.nikki.leetc.kadane;

import java.util.Stack;

import com.nikki.out.Print;

/**
 *最大子数组和 
 *@author:Jesse
 *@version:2023年12月11日下午11:11:08
**/
public class RTest53 {

	public static void main(String[] args) {
//		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int[] nums = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        Print.stringOut("The max sum is:" + maxSubArray(nums));
	}
	/**
	 * 给你一个整数数组nums，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
	 * 子数组是数组中的一个连续部分。
	 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
	 * 输出：6
	 * 解释：连续子数组[4,-1,2,1]的和最大，为6。
	 * @param nums
	 * @return
	 */
    public static int maxSubArray(int[] nums) {
        int max = 0, submax = 0;
        if (nums == null || nums.length == 0) {
            return max;
        }
        Stack<Integer> stack = new Stack<Integer>();
        boolean hasStart = false;
        //思路：开始搜索，遇到第一个正数，放入备选，依次往后搜索，计算和；遇到正数，则直接加入，遇到负数，需要计算和是否为正-为正则继续，为负则从头开始
        for (int i = 0; i < nums.length; i++) {
            //记录最大的值，在整个数组全小于等于0时这个数即为最大和
            if (i == 0) {
                submax = nums[0];
            } else {
                if (submax < nums[i]) {
                    submax = nums[i];
                }
            }
            //开始前面的策略
            if (!hasStart && nums[i] > 0) {
                stack.push(nums[i]);
                max = max + nums[i];
                hasStart = true;
            } else {
                //备选为空且当前数非正则不处理，往后继续
                if (!hasStart && nums[i] <= 0) {
                    continue;
                }
                //备选已开始，当前数非负时，加入备选
                if (nums[i] >= 0) {
                    stack.push(nums[i]);
                    max = max + nums[i];
                } else {
                    //备选已开始，当前数为负时，记录下当前最大和；加入负数和为正时，继续往前，否则从头开始
                    if (submax < max) submax = max;
                    if (max + nums[i] > 0) {
                        stack.push(nums[i]);
                        max = max + nums[i];
                    } else {
                        //从头开始
                        max = 0;
                        hasStart = false;
                        stack.clear();
                    }
                }
            }
        }
        //如果全部元素小于0，或者取局部最大值
        if (submax < 0 || submax > max) {
            max = submax;
        }
        return max;
    }
}
