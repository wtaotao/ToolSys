package com.nikki.leetc.binarytree;

import com.nikki.leetc.binarytree.RTest101.TreeNode;
import com.nikki.out.Print;

/**
 * 二叉树展开为链表
 *@author:Jesse
 *@version:2023年11月22日下午11:47:00
**/
public class RTest114 {

	public static void main(String[] args) {
		int[] nums = {1,2,5,3,4,-1,6};
		RTest114 test = new RTest114();
		
	      TreeNode p21 = test.new TreeNode(3);
	      TreeNode p22 = test.new TreeNode(4);
	      TreeNode p24 = test.new TreeNode(6);
	      TreeNode p11 = test.new TreeNode(2, p21, p22);
	      TreeNode p12 = test.new TreeNode(5, null, p24);
	      TreeNode p0 = test.new TreeNode(1, p11, p12);
	      
	      flatten(p0);
	      
	      Print.stringOut(p0.toString());
	}
	/**
	 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
	 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
	 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
	 * 输入：root = [1,2,5,3,4,null,6]
	 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
	 * @param root
	 */
    public static void flatten(TreeNode root) {
        if (root != null) {
            if (root.left != null)
            {
                flatten(root.left);
                root.left = root;
            }
            if (root.right != null) {
                flatten(root.right);
            }
        }
    }
    /**
     * Definition for a binary tree node.
     **/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
            }
    }
}
