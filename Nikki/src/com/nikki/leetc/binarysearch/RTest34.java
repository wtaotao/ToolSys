package com.nikki.leetc.binarysearch;

import com.nikki.out.Print;

/**
 *在排序数组中查找元素的第一个和最后一个位置
 *@author:Jesse
 *@version:2023年12月11日下午11:25:48
**/
public class RTest34 {

	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		RTest34 test = new RTest34();
		Print.arrayOut(test.searchRange(nums, target));
	}
	/**
	 * 给你一个按照非递减顺序排列的整数数组nums，和一个目标值target。请你找出给定目标值在数组中的开始位置和结束位置。
	 * 如果数组中不存在目标值target，返回[-1, -1]。
	 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
	 * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
	 * @param nums
	 * @param target
	 * @return
	 */
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        //左标小于等于右标，小于数组长度，且左右元素值等于目标值
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        } 
        return new int[]{-1, -1};
    }
    /**
     * 
     * <pre>
     *
     * </pre>
     *
     * @param nums 非递减整数数组
     * @param target 目标值
     * @param lower 低下标
     * @return
     */
    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        //左标不大于右标
        while (left <= right) {
            //中间值
            int mid = (left + right) / 2;
            //中间值大于目标值，或者搜结果左区间时中间值大于等于目标值
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                //右标设为mid-1，结果设为mid
                right = mid - 1;
                ans = mid;
            } else {
                //否则左标设为mid+1
                left = mid + 1;
            }
        }
        return ans;
    }
}
