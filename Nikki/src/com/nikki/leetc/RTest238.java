/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * <pre>
 * 除自身以外数组的乘积
 * </pre>
 *
 * @author wangyanjun
 * @filename RTest238.java
 * @version v0.1 2023年11月8日
 * @time 下午1:43:06 
 *
 */
public class RTest238 {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4};
        int[] nums = {-1,1,0,-3,3};
        Print.arrayOut(productExceptSelf(nums));

    }
    /**
     * <pre>
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在32位整数范围内。
     * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
     * 输入: nums = [1,2,3,4] 输出: [24,12,8,6]
     * 输入: nums = [-1,1,0,-3,3] 输出: [0,0,9,0,0]
     * </pre>
     *
     * @param nums
     * @return
     */
//    public static int[] productExceptSelf(int[] nums) {
//        int[] answer = new int[nums.length];
//        for (int i=0; i<nums.length; i++) {
//            answer[i] = 1;
//        }
//        for (int i=0; i<nums.length; i++) {
//            for (int j=0; j<nums.length; j++) {
//                if (j != i) answer[i] = nums[j]*answer[i];
//            }
//        }
//        return answer;
//    }
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] ans = new int[len];
        ans[0] = 1;
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            ans[i] *= tmp;
        }

        return ans;
    }
}
