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
        //创建一个临时数组来存放轮转后的数组元素
        int[] temp = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
        	temp[(i+k)%nums.length] = nums[i];
        }
        //赋值轮转后的值
        for (int i=0; i<nums.length; i++) {
        	nums[i] = temp[i];
        }
    }
}
