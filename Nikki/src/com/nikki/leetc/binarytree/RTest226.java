package com.nikki.leetc.binarytree;

import com.nikki.leetc.TreeNode;

/**
 * 翻转二叉树
 *@author:Jesse
 *@version:2023年11月21日下午11:51:53
**/
public class RTest226 {

	public static void main(String[] args) {
	    RTest226 test = new RTest226();
	    
	    Integer[] root = {4,2,7,1,3,6,9};
	    TreeNode tree = TreeNode.constructTree(root);

        test.invertTree(tree);
	}
	/**
	 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
	 * 输入：root = [4,2,7,1,3,6,9]
	 * 输出：[4,7,2,9,6,3,1]
	 * @param root
	 * @return
	 */
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
