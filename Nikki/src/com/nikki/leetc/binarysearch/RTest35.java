package com.nikki.leetc.binarysearch;

import com.nikki.out.Print;

/**
 *搜索插入位置
 *@author:Jesse
 *@version:2023年12月11日下午11:16:31
**/
public class RTest35 {

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
        int target = 5;
        RTest35 test = new RTest35();
        Print.stringOut("The index is:" + test.searchInsert(nums, target));
	}
	/**
	 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 * 请必须使用时间复杂度为O(log n)的算法。
	 * 输入: nums = [1,3,5,6], target = 5
	 * 输出: 2
	 * @param nums
	 * @param target
	 * @return
	 */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        //从头尾开始折半查找
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            //计算中间值
            int mid = ((right - left) >> 1) + left;
            //目标值小于等于中间值，右标前移为mid-1，结果设为中间值
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                //否则左标设为mid+1
                left = mid + 1;
            }
        }
        return ans;
    }
}
