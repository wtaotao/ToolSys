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
 * @filename RTest27.java
 * @version v0.1 2023年11月7日
 * @time 上午10:34:21 
 *
 */
public class RTest27 {

    /**
     * <pre>
     * 给你一个数组nums和一个值val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用O(1)额外空间并原地修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] nums = {3,2,2,3}; 
//        int val = 3;
        int[] nums = {0,1,2,2,3,0,4,2}; 
        int val = 2;
        Print.stringOut("The array is:");
        Print.arrayOut(nums);
        int length = removeElement(nums, val);
        Print.stringOut("The array after removing " + val);
        Print.arrayOut(nums);
        Print.stringOut("The array length after removing is " + length);
    }
    
    public static int removeElement(int[] nums, int val) {

        int movedSum = 0;
        for (int i=0; i<=nums.length-movedSum-1; ) {
            //与val比较，相等则后面所有的元素前移，同时移除元素总数加一
            if (nums[i] == val) {
                for (int j=i; j<nums.length-movedSum-1; j++) {
                    nums[j] = nums[j+1];
                }
                movedSum++;
            } else {
                //不等则比较下一个
                i++;
            }
        }
        return nums.length-movedSum;
    }

}
