package com.nikki.leetc.binarysearchtree;
/**
 * 二叉搜索树的最小绝对差
 *@author:Jesse
 *@version:2023年11月26日下午11:06:37
**/

public class RTest530 {
    int pre;
    int ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
	 * 差值是一个正数，其数值等于两值之差的绝对值。
	 * 输入：root = [4,2,6,1,3]
	 * 输出：1
	 * @param root
	 * @return
	 */
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
    /**
     * Definition for a binary tree node.
     **/
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         public TreeNode(int val) { 
             this.val = val; 
         }
         TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
           }
     }
}
