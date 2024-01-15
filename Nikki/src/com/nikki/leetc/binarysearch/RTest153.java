package com.nikki.leetc.binarysearch;

import com.nikki.out.Print;

/**
 *寻找旋转排序数组中的最小值
 *@author:Jesse
 *@version:2023年12月11日下午11:26:57
**/
public class RTest153 {

	public static void main(String[] args) {
		int[] nums = {3,4,5,1,2};
		Print.stringOut("The min is:" + findMin(nums));
	}
	/**
	 * 已知一个长度为n的数组，预先按照升序排列，经由1到n次旋转后，得到输入数组。例如，原数组nums = [0,1,2,4,5,6,7]在变化后可能得到：
	 * * 若旋转4次，则可以得到[4,5,6,7,0,1,2]
	 * * 若旋转7次，则可以得到[0,1,2,4,5,6,7]
	 * 注意，数组[a[0], a[1], a[2], ..., a[n-1]]旋转一次的结果为数组[a[n-1], a[0], a[1], a[2], ..., a[n-2]]。
	 * 给你一个元素值互不相同的数组nums，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的最小元素。
	 * 你必须设计一个时间复杂度为O(log n)的算法解决此问题。
	 * 输入：nums = [3,4,5,1,2]
     * 输出：1
     * 解释：原数组为[1,2,3,4,5]，旋转3次得到输入数组。
	 * @param nums
	 * @return
	 */
    public static int findMin(int[] nums) {
        int min = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0) {
            return min;
        }
        min = nums[0];
        //思路：第一个元素往后搜索，最小值为第一个元素，或者第一个比前一个小的元素
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
                break;
            }
        }
        return min;
    }
}
