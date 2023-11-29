package com.nikki.leetc.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

import com.nikki.leetc.TreeNode;
import com.nikki.out.Print;

/**
 * 二叉树中的最大路径和
 *@author:Jesse
 *@version:2023年11月23日下午11:28:16
**/
public class RTest124 {

	public static void main(String[] args) {
		RTest124 test = new RTest124();
		Integer[] root = {1,2,3};
		Print.stringOut("The largest sum is:" + test.maxPathSum(test.constructTree(root)));
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
	 * 二叉树中的路径被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中至多出现一次 。该路径至少包含一个节点，且不一定经过根节点。
	 * 路径和是路径中各节点值的总和。
	 * 给你一个二叉树的根节点 root ，返回其最大路径和。
	 * 输入：root = [1,2,3]
	 * 输出：6
	 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
	 * @param root
	 * @return
	 */
    public int maxPathSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        if (root == null) return max;
        //分别左、右子树最大和，假定节点都是非零正整数值
        int lmax = maxPathSum(root.left);
        int rmax = maxPathSum(root.right);
        
        max = lmax + root.val + rmax;
        
        return max;
    }
}
