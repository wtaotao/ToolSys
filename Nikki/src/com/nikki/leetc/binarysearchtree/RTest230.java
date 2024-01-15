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
	 * 给定一个二叉搜索树的根节点root，和一个整数k，请你设计一个算法查找其中第k个最小元素（从1开始计数）。
	 * @param root
	 * @param k
	 * @return
	 */
    int res, k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        //null则返回
        if (root == null) return;
        //遍历左子树
        dfs(root.left);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        //遍历右子树
        dfs(root.right);
    }
}
