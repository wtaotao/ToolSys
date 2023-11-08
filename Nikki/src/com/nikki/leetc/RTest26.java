/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * <pre>
 *
 * </pre>
 *
 * @author wangyanjun
 * @filename RTest26.java
 * @version v0.1 2023年11月7日
 * @time 下午3:00:30 
 *
 */
public class RTest26 {

    /**
     * <pre>
     * 给你一个非严格递增排列的数组nums，请你原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。元素的相对顺序应该保持一致。
     * 然后返回nums中唯一元素的个数。
     * 考虑nums的唯一元素的数量为k ，你需要做以下事情确保你的题解可以被通过：更改数组nums，使nums的前k个元素包含唯一元素，并
     * 按照它们最初在nums中出现的顺序排列。nums的其余元素与nums的大小不重要。返回k。
     * 1 <= nums.length <= 3 * 104
     * -104 <= nums[i] <= 104
     * nums 已按 非严格递增 排列
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] nums = {1,1,2};
        int[] nums = {1,1};
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Print.stringOut("The input array is:");
        Print.arrayOut(nums);
        Print.stringOut("The new array length is:" + removeDuplicates(nums));
        Print.stringOut("The new array is:");
        Print.arrayOut(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length==1) return 1;
        int temp=nums[0], i=1, count=0;
        for (; i<=nums.length-count-1;) {
            if (nums[i]==temp) {
                for (int j=i; j<nums.length-count-1; j++) {
                    nums[j] = nums[j+1];
                }
                count++;
            } else {
                temp = nums[i];
                i++;
            }
        }
        return nums.length-count;
    }
}
