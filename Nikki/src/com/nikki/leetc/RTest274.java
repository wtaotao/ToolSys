/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import java.util.Arrays;

import com.nikki.out.Print;

/**
 * <pre>
 * H 指数
 * </pre>
 *
 * @author wangyanjun
 * @filename RTest274.java
 * @version v0.1 2023年11月8日
 * @time 上午10:49:06 
 *
 */
public class RTest274 {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] citations = {3,0,6,1,5};
        int[] citations = {1,3,1};
        Print.stringOut("The H metrics is:" + hIndex(citations));
    }
    /**
     * 
     * <pre>
     * 给你一个整数数组citations，其中citations[i]表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
     * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文
     * 至少被引用h次。如果h有多种可能的值，h指数是其中最大的那个。
     * </pre>
     *
     * @param citations
     * @return
     */
    public static int hIndex(int[] citations) {
    	Arrays.sort(citations);
        int h = 0;
        for(int i=citations.length-1; i>=0; i--) {
            //被引用次数从高到低，如果大于h，则h加一
            if (citations[i] >= h+1) {
                h++;
            } else {
                break;
            }
        }
        return h;
    }
    //冒泡排序
    public static int[] sort(int[] array) {
        // 一定要记住判断边界条件
        if (array == null || array.length < 2) {
            return array;
        } // 需要进行array.length趟比较
        for (int i = 0; i < array.length - 1; i++) {
            // 第i趟比较
            for (int j = 0; j < array.length - i - 1; j++) {
                // 开始进行比较，如果array[j]比array[j+1]的值大，那就交换位置
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
