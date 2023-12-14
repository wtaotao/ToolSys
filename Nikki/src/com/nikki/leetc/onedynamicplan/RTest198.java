package com.nikki.leetc.onedynamicplan;

import com.nikki.out.Print;

/**
 *打家劫舍
 *@author:Jesse
 *@version:2023年12月12日下午11:54:17
**/
public class RTest198 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		RTest198 test = new RTest198();
        Print.stringOut("The max sum is:" + test.rob(nums));
	}
	/**
	 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋
	 * 在同一晚上被小偷闯入，系统会自动报警。
	 * 给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下，一夜之内能够偷窃到的最高金额。
	 * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃1号房屋(金额=1)，然后偷窃3号房屋(金额=3)。
     * 偷窃到的最高金额= 1 + 3 = 4 。
	 * @param nums
	 * @return
	 */
    public int rob(int[] nums) {
        //思路：不自动报警就不能连续偷,可以选择每隔一个或者两个进行偷窃，否则中间可以多偷一家房屋而不触发报警;最高金额的肯定从第一家或者第二家开始偷窃
        int max = 0;
        if (nums == null || nums.length == 0) return max;
        for (int i = 0; i < 2; i++) {
            for (int j = 2; j <=3; j++) {
                int sum = sum(nums, i, j);
                if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }
    
    private int sum(int[] nums, int start, int step) {
        int sum = 0;
        for (int i = start; i < nums.length; i += step) {
            sum += nums[i];
        }
        return sum;
    }
    
}
