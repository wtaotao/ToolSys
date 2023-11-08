/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

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
        // TODO Auto-generated method stub

    }
    public int trap(int[] height) {
        int max = 0, sum = 0;
        for(int i=0; i<height.length; i++) {
            if(max < height[i]) max = height[i];
        }
        for(int i=1; i<=max; i++) {
            for()
        }
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
