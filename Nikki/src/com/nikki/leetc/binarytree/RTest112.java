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
	    TreeNode tree = TreeNode.constructTree(root);
        Print.stringOut("The result is:" + test.hasPathSum(tree, 22));
	}
	/**
	 *  给你二叉树的根节点root和一个表示目标和的整数targetSum。判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和
	 *  targetSum。如果存在，返回true；否则，返回false。
	 *  叶子节点是指没有子节点的节点。
	 *  输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
	 *  输出：true
	 *  解释：等于目标和的根节点到叶节点路径如上图所示。
	 * @param root
	 * @param targetSum
	 * @return
	 */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        boolean hasPath = false;
        if (root != null) {
            hasPath = hasPathSum1(root.left, targetSum-root.val) || hasPathSum1(root.right, targetSum-root.val);
        }
        return hasPath;
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        
    }
}
