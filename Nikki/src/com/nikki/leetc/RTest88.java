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
        //创建一个结果数组，长度为输入数组长度和
        int[] temp = new int[m+n];
        int i = m-1,j = n-1;
        //从最大值开始取并插入和数组
        for (int k=m+n-1; i >= 0 && j >= 0; k--) {
            //nums2的元素值较大，取出放入和数组
            if (nums1[i] <= nums2[j]) {
                temp[k] = nums2[j];
                j--;
            } else {
                //否则取nums1的值放入和数组
                temp[k] = nums1[i];
                i--;
            }
        }
        //nums1还存在元素，把合并排好序的元素挨个插入nums1后面
        if (i>=0) {
            for (int l = i+1; l <= m+n-1; l++) {
                nums1[l] = temp[l];
            }
        }
        //nums2还存在元素，则把nums2的剩余元素和合并排好序的和数组元素插入nums1
        if (j>=0) {
            //插入nums2剩余的元素至nums1
            for (int l = 0; l <= j; l++) {
                nums1[l] = nums2[l];
            }
            //插入排好序的和数组的元素
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
        //从两输入数组的最后元素开始比较合并
        for (int k=m+n-1; i >= 0 && j >= 0; k--) {
            //取相较更大的元素插入nums1最后，被取的数组指针前移
            if (nums1[i] <= nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
        }
        //nums2还有未取的元素，则挨个插入nums1
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
