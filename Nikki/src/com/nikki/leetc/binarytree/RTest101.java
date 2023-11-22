package com.nikki.leetc.binarytree;
/**
 * 对称二叉树
 *@author:Jesse
 *@version:2023年11月21日下午11:53:06
**/
public class RTest101 {

	public static void main(String[] args) {
		RTest101 test = new RTest101();
		
		TreeNode p21 = test.new TreeNode(3);
		TreeNode p22 = test.new TreeNode(4);
		TreeNode p23 = test.new TreeNode(4);
		TreeNode p24 = test.new TreeNode(3);
		TreeNode p11 = test.new TreeNode(2, p21, p22);
		TreeNode p12 = test.new TreeNode(2, p23, p24);
		TreeNode p0 = test.new TreeNode(1, p11, p12);
		
		
		
	}
	/**
	 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
	 * 输入：root = [1,2,2,3,4,4,3]
	 * 输出：true
	 * @param root
	 * @return
	 */
    public boolean isSymmetric(TreeNode root) {
        boolean flag = false;
        if (root == null || root.left == null || root.right == null) {
            if (root == null || root.left == null && root.right == null) {
                return true;
            } else {
                return false;
            }
        }
        
        return flag;
    }
    /**
     * Definition for a binary tree node.
     **/ 
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { 
            this.val = val; 
            }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
            }
     }
}
