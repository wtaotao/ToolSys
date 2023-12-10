package com.nikki.leetc.binarysearchtree;

import com.nikki.leetc.TreeNode;

/**
 *验证二叉搜索树 
 *@author:Jesse
 *@version:2023年12月8日下午11:15:39
**/
public class RTest98 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
