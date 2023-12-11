package com.nikki.leetc.binarytree;

import com.nikki.leetc.TreeNode;
import com.nikki.out.Print;

/**
 * 二叉树的最大深度
 *@author:Jesse
 *@version:2023年11月21日下午11:46:27
**/
public class RTest104 {

	public static void main(String[] args) {
	    RTest104 test = new RTest104();
	    
	    Integer[] root = {3,9,20,null,null,15,7};
	    TreeNode tree = TreeNode.constructTree(root);
	    
	    Print.stringOut("The max depth is :" + test.maxDepth(tree));
	}
	/**
	 * 给定一个二叉树 root ，返回其最大深度。
	 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
	 * 输入：root = [3,9,20,null,null,15,7]
	 * 输出：3
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
         int depth = 0;
         if (root != null) {
             depth = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
         }
         return depth;
    }
}
