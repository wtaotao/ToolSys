/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * <pre>
 * 加油站
 * </pre>
 *
 * @author wangyanjun
 * @filename RTest134.java
 * @version v0.1 2023年11月8日
 * @time 下午3:10:18 
 *
 */
public class RTest134 {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] gas = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
//        int[] gas = {2,3,4};
//        int[] cost = {3,4,3};
//        int[] gas = {5,8,2,8};
//        int[] cost = {6,5,6,6};
        int[] gas = {2,0,0};
        int[] cost = {0,1,0};
        Print.stringOut("The start station is:" + canCompleteCircuit(gas, cost));

    }
    /**
     * 
     * <pre>
     * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则保证它是唯一的。
     * 
     * </pre>
     *
     * @param gas
     * @param cost
     * @return
     */
//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int gassum = 0, costsum = 0, start = -1, maxCost = 0;
//        for (int i=0; i<gas.length; i++) {
//            gassum += gas[i];
//        }
//        for (int i=0; i<cost.length; i++) {
//            costsum += cost[i];
//            if (maxCost < cost[i]) {
//                maxCost = cost[i];
//                start = i+1;
//            }
//        }
//        if (gassum < costsum) start = -1;
//        return start;
//    }
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

}
