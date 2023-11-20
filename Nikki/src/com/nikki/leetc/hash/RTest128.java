package com.nikki.leetc.hash;

import java.util.HashSet;
import java.util.Set;

import com.nikki.out.Print;

/**
 * 最长连续序列
 * @author Jesse
 *
 */
public class RTest128 {

	public static void main(String[] args) {
//		int[] nums = {1, 2, 3, 4};
		int[] nums = {100,4,200,1,3,2};
//		int[] nums = {0,3,7,2,5,8,4,6,0,1};
        Print.stringOut("The longest is:" + longestConsecutive(nums));
	}
	/**
	 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
	 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
	 * 输入：nums = [100,4,200,1,3,2]
	 * 输出：4
	 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
	 * @param nums
	 * @return
	 */
	public static int longestConsecutive(int[] nums) {
	    int len = 0;
	    int[] temp = new int[nums.length];
	    for (int i = 0; i < temp.length; i++) {
	    	temp[i] = -1;
	    }
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] >= 0 && nums[i] < temp.length) {
	            temp[nums[i]] = nums[i];
	        } 
	    }
	    int i = 0;
	    while (i < temp.length) {
	    	if (temp[i] != -1) {
	    		len++;
	    	}
	    	i++;
	    }
	    return len;
	}
}
