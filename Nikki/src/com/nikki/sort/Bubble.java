/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.sort;

import com.nikki.out.Print;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jesse Wang
 * @filename Bubble.java
 * @version v0.1 
 * @time 2024年1月4日 上午9:09:47 
 *
 */
public class Bubble {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {4,2,1,6,7,8};
        sort(nums);
        Print.arrayOut(nums);
    }
    
    public static void sort(int nums[]) {
        //待排序数组为空或者少于等于1个元素，直接返回
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    
    private int adjustArray(int s[], int l, int r) {
        int i = l, j = r;
        int x = s[i];
        
        while(i < j) {
            //从右向左扫描比较
            while(i < j && x <= s[j]) {
                j--;
            }
            if (i < j) {
                s[i] = s[j];
                i++;
            }
            //从左向右扫描比较
            while(i < j && x > s[i]) {
                i++;
            }
            if (i < j) {
                s[j] = s[i];
                j--;
            }
        }
        
        s[i] = x;
        return i;
    }
}
