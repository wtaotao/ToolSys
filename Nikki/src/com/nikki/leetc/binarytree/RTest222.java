package com.nikki.leetc.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

import com.nikki.leetc.TreeNode;
import com.nikki.out.Print;

/**
 * 完全二叉树的节点个数
 *@author:Jesse
 *@version:2023年11月23日下午11:33:42
**/
public class RTest222 {

	public static void main(String[] args) {
	    RTest222 test = new RTest222();
		Integer[] root = {1,2,3,4,5,6};
		TreeNode tree = TreeNode.constructTree(root);
		Print.stringOut("The node number is:" + test.countNodes(tree));
	}
	/**
	 * 给你一棵完全二叉树的根节点root，求出该树的节点个数。
	 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
	 * 若最底层为第h层，则该层包含1~2h个节点。
	 * 输入：root = [1,2,3,4,5,6]
	 * 输出：6
	 * @param root
	 * @return
	 */
    public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) return count;
        count = 1 + countNodes(root.left) + countNodes(root.right);
        return count;
    }
}
