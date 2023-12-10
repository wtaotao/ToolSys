package com.nikki.leetc.binarysearchtree;

import com.nikki.leetc.TreeNode;

/**
 *二叉搜索树中第K小的元素 
 *@author:Jesse
 *@version:2023年12月8日下午11:09:00
**/
public class RTest230 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
	 * @param root
	 * @param k
	 * @return
	 */
    int res, k;
    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
}
