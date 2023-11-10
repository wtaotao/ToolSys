/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * <pre>
 * 跳跃游戏 II
 * </pre>
 *
 * @author wangyanjun
 * @filename RTest45.java
 * @version v0.1 2023年11月8日
 * @time 上午9:10:14 
 *
 */
public class RTest45 {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
//        int[] nums = {2,3,0,1,4};
        int[] nums = {0};
        Print.stringOut("The step number is:" + jump(nums));
    }
    /**
     * 
     * <pre>
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     * 0 <= j <= nums[i]
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     * 
     * </pre>
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        //假定数组元素全部为正整数
        int step = 0, submax = 0, index = 0;
        do {
            for (int i=0; i<nums[index]; i++) {
                if (submax < nums[index+i]) {
                    submax = nums[index+i];
                }
                if (index+submax >= nums.length-1) {
                    break;
                }
            }
            if (submax == 0) {
            	return -1;
            }
            index = index+submax;
            submax = 0;
            step++;
        } while(index < nums.length-1);
        
        return step;
    }

}
