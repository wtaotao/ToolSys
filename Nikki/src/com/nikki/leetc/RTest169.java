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
 * @filename RTest169.java
 * @version v0.1 2023年11月7日
 * @time 下午1:13:08 
 *
 */
public class RTest169 {

    /**
     * <pre>
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] nums = {3,2,3};
        int[] nums = {2,2,1,1,1,2,2};
        Print.stringOut("The input array is:");
        Print.arrayOut(nums);
        int value = majorityElement(nums);
        Print.stringOut("The majority element is " + value);
    }
    
    /**
     * 
     * <pre>
     *     n == nums.length
     *     1 <= n <= 5 * 10(4次幂)
     *     -10（9次幂） <= nums[i] <= 10（9次幂）
     * </pre>
     *
     * @param nums
     * @return
     */
    private static int majorityElement(int[] nums) {
        
        if (nums==null) return 256;
        
        int[] count = new int[(int) (2*Math.pow(10, 9)+1)];
        for (int i=0; i<nums.length; i++) {
            int j = (int) (nums[i] + Math.pow(10, 9));
            count[j]++;
        }
        
        int temp = 0, index = 0;
        for (int k=0; k<count.length; k++) {
            if (temp < count[k]) {
                temp = count[k];
                index = k;
            }
        }
        
        if (temp > nums.length/2) {
            return (int) (index-Math.pow(10, 9));
        } else
        {
            return 0;
        }
    }
}
