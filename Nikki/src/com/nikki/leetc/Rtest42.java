/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * <pre>
 * 接雨水
 * </pre>
 *
 * @author wangyanjun
 * @filename Rtest42.java
 * @version v0.1 2023年11月8日
 * @time 下午4:18:57 
 *
 */
public class Rtest42 {

    /**
     * <pre>
     * 给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4,2,0,3,2,5};
        Print.stringOut("The sum is:" + trap(height));
    }
    public static int trap(int[] height) {
        int max = 0, sum = 0;
        for(int i=0; i<height.length; i++) {
            if(max < height[i]) max = height[i];
        }
        for(int i=1; i<=max; i++) {
            for(int j=0; j<height.length; j++) {
                height[j] = height[j]-1;
            }
            sum = sum + count(height);
        }
        return sum;
    }
    
    private static int count(int[] a) {
        int start = 0, end = 0, sum = 0;
        for(int i=0; i<a.length; i++) {
            if (a[i] >= 0) {
                start = i;
                break;
            }
        }
        for(int i=a.length-1; i>=0; i--) {
            if (a[i] >= 0) {
                end = i;
                break;
            }
        }
        if(start < end) {
            for(int i=start+1; i<end; i++) {
                if(a[i] < 0) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
