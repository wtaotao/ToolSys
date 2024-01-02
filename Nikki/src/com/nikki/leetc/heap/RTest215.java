package com.nikki.leetc.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nikki.out.Print;

/**
 *数组中的第K个最大元素
 *@author:Jesse
 *@version:2023年12月11日下午11:30:30
**/
public class RTest215 {

	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
        int k = 2;
        Print.stringOut("The kth largest is:" + findKthLargest(nums, k));
	}
	/**
	 * 给定整数数组nums和整数k，请返回数组中第k个最大的元素。
	 * 请注意，你需要找的是数组排序后的第k个最大的元素，而不是第k个不同的元素。
	 * 你必须设计并实现时间复杂度为O(n)的算法解决此问题。
	 * 输入: [3,2,1,5,6,4], k = 2
     * 输出: 5
	 * @param nums
	 * @param k
	 * @return
	 */
	//超时
    public static int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return Integer.MIN_VALUE;
        }
        int[] temp = new int[nums.length];
        int count = 1;
        temp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = count-1; j >= 0; j--) {
                if (temp[j] <= nums[i]) {
                    //后面插入
                    temp[j+1] = nums[i];
                    count++;
                    break;
                } else {
                    //否则当前数往后移一位
                    temp[j+1] = temp[j];
                    //所有已排序值都比当前值大，插入到第一个
                    if (j == 0) {
                        temp[j] = nums[i];
                        count++;
                    }
                }
            }
        }
        
        return temp[temp.length - k];
    }
    private static int quickSelect(List<Integer> nums, int k) {
        // 随机选择基准数
        Random rand = new Random();
        int pivot = nums.get(rand.nextInt(nums.size()));
        // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot)
                big.add(num);
            else if (num < pivot)
                small.add(num);
            else
                equal.add(num);
        }
        // 第 k 大元素在 big 中，递归划分
        if (k <= big.size())
            return quickSelect(big, k);
        // 第 k 大元素在 small 中，递归划分
        if (nums.size() - small.size() < k)
            return quickSelect(small, k - nums.size() + small.size());
        // 第 k 大元素在 equal 中，直接返回 pivot
        return pivot;
    }
    
    public static int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }
}
