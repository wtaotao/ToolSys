package com.nikki.leetc;
/**
 * 轮转数组
 * @author Jesse
 *
 */
public class RTest189 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
	 */
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
        	temp[(i+k)%nums.length] = nums[i];
        }
        for (int i=0; i<nums.length; i++) {
        	nums[i] = temp[i];
        }
    }
}
