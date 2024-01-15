package com.nikki.leetc.binarysearch;

import com.nikki.out.Print;

/**
 *寻找峰值
 *@author:Jesse
 *@version:2023年12月11日下午11:22:07
**/
public class RTest162 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,1}; 
        Print.stringOut("The peak element is:" + findPeakElement(nums));
	}
	/**
	 * 峰值元素是指其值严格大于左右相邻值的元素。
	 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
	 * 你可以假设 nums[-1] = nums[n] = -∞。
	 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
	 * 输入：nums = [1,2,3,1]
     * 输出：2
     * 解释：3是峰值元素，你的函数应该返回其索引2。
	 * @param nums
	 * @return
	 */
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (; left < right; ) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
