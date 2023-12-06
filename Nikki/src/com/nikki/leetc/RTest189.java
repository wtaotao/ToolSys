package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * 轮转数组
 * @author Jesse
 *
 */
public class RTest189 {

	public static void main(String[] args) {
		int[] nums = {2,7,5,4,8};
		int k = 2;
		rotate(nums, k);
		Print.arrayOut(nums);
	}
	/**
	 * 给定一个整数数组nums，将数组中的元素向右轮转k个位置，其中k是非负数。
	 */
    public static void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
        	temp[(i+k)%nums.length] = nums[i];
        }
        for (int i=0; i<nums.length; i++) {
        	nums[i] = temp[i];
        }
    }
}
