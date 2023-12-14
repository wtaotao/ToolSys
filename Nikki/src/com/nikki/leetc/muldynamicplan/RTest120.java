package com.nikki.leetc.muldynamicplan;

import java.util.List;

/**
 *三角形最小路径和
 *@author:Jesse
 *@version:2023年12月13日下午10:27:58
**/
public class RTest120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给定一个三角形triangle，找出自顶向下的最小路径和。
	 * 每一步只能移动到下一行中相邻的结点上。相邻的结点在这里指的是下标与上一层结点下标相同或者等于上一层结点下标+1的两个结点。
	 * 也就是说，如果正位于当前行的下标i，那么下一步可以移动到下一行的下标i或i+1。
	 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
	 * @param triangle
	 * @return
	 */
    public int minimumTotal(List<List<Integer>> triangle) {
        //思路：每次可以看到下一步的最小值，但是无法看到之后的最小值，故需要用到尝试和回退
        
    }
}
