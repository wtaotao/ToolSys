package com.nikki.leetc.binarytree;

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
//		Integer[] root = {1,2,3};
		Integer[] root = {-10,9,20,null,null,15,7};
		Print.stringOut("The largest sum is:" + test.maxPathSum(TreeNode.constructTree(root)));
	}
	/**
	 * 二叉树中的路径被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中至多出现一次 。
	 * 该路径至少包含一个节点，且不一定经过根节点。
	 * 路径和是路径中各节点值的总和。
	 * 给你一个二叉树的根节点root，返回其最大路径和。
	 * 输入：root = [1,2,3]
	 * 输出：6
	 * 解释：最优路径是2 -> 1 -> 3，路径和为2 + 1 + 3 = 6
	 * @param root
	 * @return
	 */
    //[-10,9,20,null,null,15,7]时错误
    public int maxPathSum1(TreeNode root) {
        int max = 0;
        if (root == null) return max;
        //分别左、右子树最大和，假定节点都是非零正整数值
        int lmax = Math.max(maxPathSum1(root.left), 0);
        int rmax = Math.max(maxPathSum1(root.right), 0);
        max = lmax + root.val + rmax;
        return max;
    }
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}
