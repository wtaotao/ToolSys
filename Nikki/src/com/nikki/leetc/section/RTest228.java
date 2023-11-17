package com.nikki.leetc.section;

import java.util.ArrayList;
import java.util.List;

import com.nikki.out.Print;

/**
 * 汇总区间
 * @author Jesse
 *
 */
public class RTest228 {

	public static void main(String[] args) {
		int[] nums = {0,1,2,4,5,7}; 
		List<String> list = summaryRanges(nums);
		for (String s: list) {
		    Print.stringOut(s);
		}
	}
	/**
	 * 给定一个  无重复元素 的 有序 整数数组 nums 。
	 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 
	 * nums 的数字 x 。
	 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
	 * "a->b" ，如果 a != b
	 * "a" ，如果 a == b
	 * 输入：nums = [0,1,2,4,5,7]
	 * 输出：["0->2","4->5","7"]
	 * 解释：区间范围是：
	 * [0,2] --> "0->2"
	 * [4,5] --> "4->5"
	 * [7,7] --> "7"
	 * @param nums
	 * @return
	 */
	public static List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
		    return list;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(nums[0]);
		int prev = nums[0];
		for (int i = 1; i < nums.length; i++) {
		    if (nums[i] == prev + 1) {
		        prev++;
		        if (i == nums.length-1) {
		            sb.append("->").append(prev);
		            list.add(sb.toString());
		        }
		    } else {
		        if (sb.length() == 0) {
		            sb.append(prev);
		            list.add(sb.toString());
		            sb = new StringBuffer();
		            prev = nums[i];
		            sb.append(prev);
		        } else {
		            sb.append("->").append(prev);
		            list.add(sb.toString());
		            sb = new StringBuffer();
		            prev = nums[i];
		            sb.append(prev);
		        }
		        if (i == nums.length-1) {
		            list.add(sb.toString());
		        }
		    }
		}
		return list;
	}
}
