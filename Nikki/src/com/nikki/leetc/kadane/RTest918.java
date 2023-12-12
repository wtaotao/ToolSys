package com.nikki.leetc.kadane;

import java.util.Stack;

import com.nikki.out.Print;

/**
 *环形子数组的最大和
 *@author:Jesse
 *@version:2023年12月11日下午11:13:08
**/
public class RTest918 {

	public static void main(String[] args) {
//		int[] nums = {1,-2,3,-2};
		int[] nums = {-5,4,-6};
        Print.stringOut("The max sum is:" + maxSubarraySumCircular(nums));
	}
	/**
	 * 给定一个长度为n的环形整数数组nums，返回nums的非空子数组的最大可能和。
	 * 环形数组意味着数组的末端将会与开头相连呈环状。形式上，nums[i]的下一个元素是nums[(i + 1) % n]，nums[i]的前一个元素是 
	 * nums[(i - 1 + n) % n] 。
	 * 子数组最多只能包含固定缓冲区nums中的每个元素一次。形式上，对于子数组nums[i],nums[i + 1],...,nums[j]，不存在 
	 * i <= k1, k2 <= j其中 k1 % n == k2 % n 。
	 * 输入：nums = [1,-2,3,-2]
	 * 输出：3
	 * 解释：从子数组[3]得到最大和3
	 * @param nums
	 * @return
	 */
	//nums = [5,-3,5]会出错
    public static int maxSubarraySumCircular1(int[] nums) {
        //思路：利用上一题的思路，但需循环搜索至第一次重新开始的位置
        //开始搜索，遇到第一个正数，放入备选，依次往后搜索，计算和；遇到正数，则直接加入，遇到负数，需要计算和是否为正-为正则继续，为负则从头开始
        int max = 0;
        if (nums == null || nums.length == 0) {
            return max;
        }
        int submax = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int n = nums.length;
        boolean hasStart = false;
        for (int i = 0; i < nums.length*2; i++) {
            //记录最大的值，在整个数组全小于等于0时这个数即为最大和
            if (i == 0) {
                submax = nums[0];
            } else {
                if (submax < nums[i%n]) {
                    submax = nums[i%n];
                }
            }
            //开始前面的策略
            if (!hasStart && nums[i%n] > 0) {
                //循环一圈再次开始时中断跳出
                if (i > n-1) {
                    break;
                }
                stack.push(nums[i%n]);
                max = max + nums[i%n];
                hasStart = true;
            } else {
                //备选为空且当前数非正则不处理，往后继续
                if (!hasStart && nums[i%n] <= 0) {
                    continue;
                }
                //备选已开始，当前数非负时，加入备选
                if (nums[i%n] >= 0) {
                    if (stack.size() == n) break;
                    stack.push(nums[i%n]);
                    max = max + nums[i%n];
                } else {
                    //备选已开始，当前数为负时，记录下当前最大和；加入负数和为正时，继续往前，否则从头开始
                    if (submax < max) submax = max;
                    if (max + nums[i%n] > 0) {
                        if (stack.size() == n) break;
                        stack.push(nums[i%n]);
                        max = max + nums[i%n];
                    } else {
                        //从头开始
                        max = 0;
                        hasStart = false;
                        stack.clear();
                    }
                }
            }
        }
        //如果全部元素小于0，或者取局部最大值
        if (submax < 0 || submax > max) {
            max = submax;
        }
        return max;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        // 对坐标为 0 处的元素单独处理，避免考虑子数组为空的情况
        leftMax[0] = nums[0];
        int leftSum = nums[0];
        int pre = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(res, pre);
            leftSum += nums[i];
            leftMax[i] = Math.max(leftMax[i - 1], leftSum);
        }

        // 从右到左枚举后缀，固定后缀，选择最大前缀
        int rightSum = 0;
        for (int i = n - 1; i > 0; i--) {
            rightSum += nums[i];
            res = Math.max(res, rightSum + leftMax[i - 1]);
        }
        return res;
    }
}
