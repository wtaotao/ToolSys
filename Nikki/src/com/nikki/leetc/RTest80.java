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
 * @filename RTest80.java
 * @version v0.1 2023年11月7日
 * @time 下午1:59:02 
 *
 */
public class RTest80 {

    /**
     * <pre>
     * 给你一个有序数组 nums ，请你原地删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] nums = {1,1,1,2,2,3};
        int[] nums = {0,0,1,1,1,1,2,3,3};
        Print.stringOut("The input array is:");
        Print.arrayOut(nums);
        int newLength = removeDuplicates(nums);
        Print.stringOut("The length of new array is:" + newLength);
        Print.stringOut("The new array is:");
        Print.arrayOut(nums);
    }
    /**
     * 
     * <pre>
     * 1 <= nums.length <= 3 * 104
     * -104 <= nums[i] <= 104
     * nums 已按升序排列
     * </pre>
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int count = 0, temp = nums[0];
        boolean flag = false;
        for (int i=1; i<nums.length-count;) {
            if (nums[i] == temp) {
                if (flag) {
                    for (int j=i; j<nums.length-count-1; j++) {
                        nums[j] = nums[j+1];
                    }
                    count++;
                } else {
                    flag = true;
                    i++;
                }
            } else {
                temp = nums[i];
                flag = false;
                i++;
            }
        }
        return nums.length-count;
    }

}
