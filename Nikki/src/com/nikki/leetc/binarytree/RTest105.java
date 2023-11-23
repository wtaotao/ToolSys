package com.nikki.leetc.binarytree;

import java.util.Stack;

/**
 * 从前序与中序遍历序列构造二叉树
 *@author:Jesse
 *@version:2023年11月22日下午11:39:54
**/
public class RTest105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
	 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
	 * 输出: [3,9,20,null,null,15,7]
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	//需参考思路
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int i = 0, j = 0;
        Stack<Integer> prestack = new Stack<Integer>();
        Stack<Integer> instack = new Stack<Integer>();
        TreeNode root = null;
        TreeNode top = null;
        boolean hasTop = false;
        while (i < preorder.length && j < inorder.length) {
            if (!hasTop) {
                if (preorder[i] == inorder[j]) {
                    top = new TreeNode(inorder[j]);
                    if (root == null) {
                        root = top;
                    }
                    hasTop = true;
                    i++;
                    j++;
                } else {
                    prestack.push(preorder[i]);
                    i++;
                }
            } else {
                if (prestack.peek() != null) {
                    int temp = prestack.pop();
                    if (temp == inorder[j]) {
                        TreeNode left = new TreeNode(inorder[j]);
                        top.left = left;
                        j++;
                    }
                }
            }
        }
        return root;
    }
    /**
     * Definition for a binary tree node.
     **/
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
             }
         }
}
