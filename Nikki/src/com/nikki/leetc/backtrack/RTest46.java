package com.nikki.leetc.backtrack;

import java.util.ArrayList;
import java.util.List;

import com.nikki.out.Print;

/**
 * 全排列
 *@author:Jesse
 *@version:2023年11月26日下午11:48:09
**/
public class RTest46 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		List<List<Integer>> combinations = permute(nums);
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < combinations.size(); j++) {
		    List<Integer> list = combinations.get(j);
		    if (j == 0) {
		        sb.append("[");
		    }
		    if (j > 0) {
		        sb.append(",");
		    }
		    for (int i = 0; i < list.size(); i++) {
		        if (i == 0) {
		            sb.append("[").append(list.get(i));
		        } else {
		            sb.append(",").append(list.get(i));
		        }
		        if (i == list.size()-1) {
		            sb.append("]");
		        }
		    }
		    if (j == combinations.size()-1) {
		        sb.append("]");
		    }
		}
		Print.stringOut(sb.toString());
	}
	/**
	 * 给定一个不含重复数字的数组nums，返回其所有可能的全排列 。你可以按任意顺序返回答案。
	 * 输入：nums = [1,2,3]
	 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
	 * @param nums
	 * @return
	 */
    public static List<List<Integer>> permute(int[] nums) {
        //创建结果列表
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        //数组为空则返回空的结果列表
        if (nums == null || nums.length == 0) {
            return combinations;
        }
        //若数组只有单个元素，直接生成结果列表
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[0]);
            combinations.add(list);
            return combinations;
        }
        //递归生成
        backtrack(nums, combinations, 0, new ArrayList<Integer>());
        return combinations;
    }
    /**
     * 
     * <pre>
     *
     * </pre>
     *
     * @param nums 可选数组
     * @param combinations 结果列表
     * @param index 当前下标
     * @param list 当前列表
     */
    private static void backtrack(int[] nums, List<List<Integer>> combinations, int index, List<Integer> list) {
        //数组长度即为结果的长度
        int len = nums.length;
        //若当前下标等于结果长度，则把当前结果插入结果集
        if (index == len) {
            List<Integer> tempList = new ArrayList<Integer>();
            tempList.addAll(list);
            combinations.add(tempList);
        } else {
            //遍历数组，挨个尝试放入结果
            for (int i = 0; i < len; i++) {
                if (!list.contains(nums[i])) {
                    list.add(nums[i]);
                    backtrack(nums, combinations, index+1, list);
                    list.remove(index);
                }
            }
        }
    }
}
