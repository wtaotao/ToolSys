package com.nikki.leetc.hash;

import com.nikki.out.Print;

/**
 * 存在重复元素 II
 * @author Jesse
 *
 */
public class RTest219 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		int k = 3;
		Print.stringOut("Is contains?" + containsNearbyDuplicate(nums, k));

	}
	/**
	 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 
	 * abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
	 * 输入：nums = [1,2,3,1], k = 3
	 * 输出：true
	 * @param nums
	 * @param k
	 * @return
	 */
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		boolean isContains = false;
		if (nums == null || nums.length <= 1 || k < 1) {
		    return isContains;
		}
		for (int i = 0; i < nums.length; i++) {
		    for (int j = i+1; j <= i+k && j < nums.length; j++) {
		        if (nums[i] == nums[j]) {
		            System.out.println("i:" + i + ", j:" + j);
		            isContains = true;
		            return isContains;
		        }
		    }
		}
		return isContains;
	}
}
