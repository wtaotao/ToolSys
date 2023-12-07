package com.nikki.leetc.binarytree.leveltraversal;

import java.util.ArrayList;
import java.util.List;

import com.nikki.leetc.TreeNode;

/**
 * 二叉树的层平均值
 *@author:Jesse
 *@version:2023年11月26日下午11:00:46
**/
public class RTest637 {

	public static void main(String[] args) {
	    Integer[] root = {3,9,20,null,null,15,7};
		TreeNode tree = TreeNode.constructTree(root);

	}
	/**
	 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
	 * 输入：root = [3,9,20,null,null,15,7]
	 * 输出：[3.00000,14.50000,11.00000]
	 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。因此返回 [3, 14.5, 11] 。
	 * @param root
	 * @return
	 */
	   public List<Double> averageOfLevels(TreeNode root) {
	        List<Integer> counts = new ArrayList<Integer>();
	        List<Double> sums = new ArrayList<Double>();
	        dfs(root, 0, counts, sums);
	        List<Double> averages = new ArrayList<Double>();
	        int size = sums.size();
	        for (int i = 0; i < size; i++) {
	            averages.add(sums.get(i) / counts.get(i));
	        }
	        return averages;
	    }

	    public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
	        if (root == null) {
	            return;
	        }
	        if (level < sums.size()) {
	            sums.set(level, sums.get(level) + root.val);
	            counts.set(level, counts.get(level) + 1);
	        } else {
	            sums.add(1.0 * root.val);
	            counts.add(1);
	        }
	        dfs(root.left, level + 1, counts, sums);
	        dfs(root.right, level + 1, counts, sums);
	    }
}
