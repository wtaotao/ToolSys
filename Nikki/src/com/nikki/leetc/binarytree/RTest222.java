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
		TreeNode tree = test.constructTree(root);
		Print.stringOut("The node number is:" + test.countNodes(tree));
	}
    private TreeNode constructTree(Integer[] root) {
        TreeNode tree = null;
        if (root == null || root[0] == null) return tree;
        //这个还不能用单纯的栈呢，得用双端队列
        Deque<TreeNode> stack = new ArrayDeque<>(); 
        tree = new TreeNode(root[0]);
        TreeNode temp = tree;
        int count = 0;
        for (int i = 1; i < root.length; i++) {
            if (count == 2) {
                temp = stack.pollFirst();
                count = 0;
            }
            if (root[i] != null) {
                TreeNode node = new TreeNode(root[i]);
                if (count == 0) {
                    temp.left = node;
                    count++;
                } else if (count == 1) {
                    temp.right = node;
                    count++;
                }
                stack.addLast(node);
            } else {
                count++;
            }
        }
        
        return tree;
    }
	/**
	 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
	 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
	 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
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
