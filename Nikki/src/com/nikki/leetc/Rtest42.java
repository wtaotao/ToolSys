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
    //
    public static int trap1(int[] height) {
        int max = 0, sum = 0;
        //找出最高的柱子
        for (int i=0; i<height.length; i++) {
            if(max < height[i]) max = height[i];
        }
        for (int i=1; i<=max; i++) {
            for (int j=0; j<height.length; j++) {
                height[j] = height[j]-1;
            }
            sum = sum + count(height);
        }
        return sum;
    }
    
    private static int count(int[] a) {
        int start = 0, end = 0, sum = 0;
        //找第一个大于零的设为起始位
        for(int i=0; i<a.length; i++) {
            if (a[i] >= 0) {
                start = i;
                break;
            }
        }
        //逆向找第一个大于零的设为结束位
        for(int i=a.length-1; i>=0; i--) {
            if (a[i] >= 0) {
                end = i;
                break;
            }
        }
        //若存在起始小于结束的正常区间
        if(start < end) {
            for(int i=start+1; i<end; i++) {
                if(a[i] < 0) {
                    sum++;
                }
            }
        }
        return sum;
    }
    
    public static int trap(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length-2
        for (int i = 1; i < height.length-1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

}
