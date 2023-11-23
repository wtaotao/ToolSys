package com.nikki.leetc.slidingwin;

import com.nikki.out.Print;

/**
 * 长度最小的子数组
 * @author Jesse
 *
 */
public class RTest209 {

	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
        int target = 7;
        Print.stringOut("The shortest is :" + minSubArrayLen(target, nums));
	}
	/**
	 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
	 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
	 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
	 * 输入：target = 7, nums = [2,3,1,2,4,3]
	 * 输出：2
	 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
	 * @param target
	 * @param nums
	 * @return
	 */
	public static int minSubArrayLen1(int target, int[] nums) {
	    int len = 0, sum = 0, max = 0, start = 0, end = 0;
	    
		for (int i=0; i<nums.length; i++) {
		    sum = sum + nums[i];
		    if (nums[i] > max) {
		        max = nums[i];
		        start = i;
		        end = i;
		    }
		}
		if (target > sum) return len;
		
		len++;
		start--;
		end++;
		while (start >=0 && end <= nums.length-1) {
		    if (nums[start] > nums[end]) {
		        sum = sum + nums[start];
		        start--;
		    } else {
		        sum = sum + nums[end];
		        end++;
		    }
		    len++;
		    if (sum >= target) {
		        break;
		    }
		}
		
	    return len;
	}
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
