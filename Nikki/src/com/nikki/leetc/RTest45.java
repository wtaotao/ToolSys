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
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
//        int[] nums = {2,3,0,1,4};
        int[] nums = {1,2,3};
        Print.stringOut("The step number is:" + jump(nums));
    }
    /**
     * 
     * <pre>
     * 给定一个长度为n的0索引整数数组nums。初始位置为nums[0]。
     * 每个元素nums[i]表示从索引i向前跳转的最大长度。换句话说，如果你在nums[i]处，你可以跳转到任意nums[i + j]处:
     * 0 <= j <= nums[i]
     * i + j < n
     * 返回到达nums[n - 1]的最小跳跃次数。生成的测试用例可以到达nums[n - 1]。
     * </pre>
     *
     * @param nums
     * @return
     */
//    public static int jump(int[] nums) {
//    	if (nums.length == 1) return 0;
//        //假定数组元素全部为正整数
//        int step = 0, submax = 0, index = 0;
//        do {
//            for (int i=0; i<nums[index]; i++) {
//                if (submax < nums[index+i]) {
//                    submax = nums[index+i];
//                }
//                if (index+submax >= nums.length-1) {
//                    break;
//                }
//            }
//            if (submax == 0) {
//            	return -1;
//            }
//            index = index+submax;
//            submax = 0;
//            step++;
//        } while(index < nums.length-1);
//        
//        return step;
//    }
    public static int jump(int[] nums) {
        // 记录当前能跳跃到的位置的边界下标
        int border = 0;
        // 记录在边界范围内，能跳跃的最远位置的下标
        int maxPosition = 0;
        // 记录所用步数
        int steps = 0;
        for(int i=0;i<nums.length-1;i++){
            // 继续往下遍历，统计边界范围内，哪一格能跳得更远，每走一步就更新一次能跳跃的最远位置下标
            // 其实就是在统计下一步的最优情况
            maxPosition = Math.max(maxPosition,nums[i]+i);
            // 如果到达了边界，那么一定要跳了，下一跳的边界下标就是之前统计的最优情况maxPosition，并且步数加1
            if(i==border){
                border = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
