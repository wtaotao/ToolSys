/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * <pre>
 * 分发糖果
 * </pre>
 * @author Jesse Wang
 * @filename RTest135.java
 * @version v0.1 2023年11月8日
 * @time 下午3:39:23 
 *
 */
public class RTest135 {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] ratings = {1,0,2};
//        int[] ratings = {1,2,2};
        int[] ratings = {1,3,2,2,1};
        Print.stringOut("The sum of candy is :" + candy(ratings));

    }
    /**
     * 
     * <pre>
     * n个孩子站成一排。给你一个整数数组ratings表示每个孩子的评分。
     * 你需要按照以下要求，给这些孩子分发糖果：
     * 每个孩子至少分配到1个糖果。
     * 相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的最少糖果数目 。
     * </pre>
     *
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        int sum = 0;
        int[] candy = new int[ratings.length];
        //首先给每个孩子各分配一个糖果
        for (int i=0; i<candy.length; i++) {
            candy[i] = 1;
        }
        //从左至右，两两比较，评分更高的孩子获得更多糖果
        for (int i=0; i<ratings.length-1; i++) {
            if (ratings[i] < ratings[i+1] && candy[i] >= candy[i+1]) {
                candy[i+1] = candy[i] + 1;
            }
        }
        //从右至左，两两比较，评分更多的孩子获得等多糖果
        for (int i=ratings.length-1; i>=1; i--) {
            if (ratings[i] < ratings[i-1] && candy[i] >= candy[i-1]) {
                candy[i-1] = candy[i] + 1;
            }
        }
        //计算糖果的总数
        for (int i=0; i<candy.length; i++) {
            sum += candy[i];
        }
        return sum;
    }
}
