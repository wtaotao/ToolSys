package com.nikki.leetc.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

import com.nikki.leetc.TreeNode;
import com.nikki.out.Print;

/**
 * 路径总和
 *@author:Jesse
 *@version:2023年11月23日下午11:22:33
**/
public class RTest112 {

	public static void main(String[] args) {
	    RTest112 test = new RTest112();
	    Integer[] root = {5,4,8,11,null,13,4,7,2,null,null,null,1};
	    TreeNode tree = test.constructTree(root);
        Print.stringOut("The result is:" + test.hasPathSum(tree, 22));
	}
	
	private TreeNode constructTree(Integer[] root) {
	    TreeNode tree = null;
	    if (root == null || root[0] == null) return tree;
        //这个还不能用单纯的栈呢，得用双端队列
        Deque<TreeNode> stack = new ArrayDeque<>(); 
        tree = new TreeNode(root[0]);
        TreeNode temp = tree;
//        stack.addFirst(tree);
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
	 *  给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
	 *  targetSum 。如果存在，返回 true ；否则，返回 false 。
	 *  叶子节点 是指没有子节点的节点。
	 *  输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
	 *  输出：true
	 *  解释：等于目标和的根节点到叶节点路径如上图所示。
	 * @param root
	 * @param targetSum
	 * @return
	 */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean hasPath = false;
        if (root != null) {
            hasPath = hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
        }
        return hasPath;
    }
}
