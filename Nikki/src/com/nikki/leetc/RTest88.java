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
 * @filename ArrayTest.java
 * @version v0.1 2023年11月7日
 * @time 上午9:11:14 
 *
 */
public class RTest88 {

    /**
     * <pre>
     * 数组相关算法问题
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,0,0};
        int[] nums2 = {0,5};
//        int[] nums1 = {1,2,2,5,0};
//        int[] nums2 = {3};
        mergeArray1(nums1,3,nums2,2);
        int[] nums3 = {1,2,2,0,0};
        int[] nums4 = {0,5};
        mergeArray2(nums3,3,nums4,2);
    }
    
    /**
     * 两个数组，nums1[],nums2[],其中分别存在m和n个整数且升序排列，nums1长度m+n,合并二者至nums1成非降序数组
     *
     */
    public static void mergeArray1(int[] nums1, int m, int[] nums2, int n) {
        // Print the input array
        Print.stringOut("The first array is:");
        Print.arrayOut(nums1);
        Print.stringOut("The second array is:");
        Print.arrayOut(nums2);
        
        int[] temp = new int[m+n];
        int i = m-1,j = n-1;
        for (int k=m+n-1; i >= 0 && j >= 0; k--) {
            if (nums1[i] <= nums2[j]) {
                temp[k] = nums2[j];
                j--;
            } else {
                temp[k] = nums1[i];
                i--;
            }
        }
        if (i>=0) {
            for (int l = i+1; l <= m+n-1; l++) {
                nums1[l] = temp[l];
            }
        }
        if (j>=0) {
            for (int l = 0; l <= j; l++) {
                nums1[l] = nums2[l];
            }
            for (int l = j+1; l <= m+n-1; l++) {
                nums1[l] = temp[l];
            }
        }
        
        //print out
        Print.stringOut("The merged array is:");
        Print.arrayOut(nums1);      
    }
    /**
     * 
     * <pre>
     *  不使用额外的存储
     * </pre>
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void mergeArray2(int[] nums1, int m, int[] nums2, int n) {
        // Print the input array
        Print.stringOut("------------mergeArray2-------------");
        Print.stringOut("The first array is:");
        Print.arrayOut(nums1);
        Print.stringOut("The second array is:");
        Print.arrayOut(nums2);
        
        int i = m-1,j = n-1;
        for (int k=m+n-1; i >= 0 && j >= 0; k--) {
            if (nums1[i] <= nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
        }
        if (j>=0) {
            for (int l = 0; l <= j; l++) {
                nums1[l] = nums2[l];
            }
        }
        
        //print out
        Print.stringOut("The merged array is:");
        Print.arrayOut(nums1);      
    }

}
