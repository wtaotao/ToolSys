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
        //节点为空，返回true
        if (node == null) {
            return true;
        }
        //小于等于低值，大于等于高值
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        //左子树和右子树都是BST
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
