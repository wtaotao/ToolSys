package com.nikki.leetc.binarytree;

import com.nikki.out.Print;

/**
 * 相同的树
 *@author:Jesse
 *@version:2023年11月21日下午11:50:21
**/
public class RTest100 {

	public static void main(String[] args) {
	    RTest100 test = new RTest100();
	    
	    TreeNode p11 = test.new TreeNode(2);
	    TreeNode p12 = test.new TreeNode(3);
	    TreeNode p0 = test.new TreeNode(1, p11, p12);
	    
	    TreeNode q11 = test.new TreeNode(2);
	    TreeNode q12 = test.new TreeNode(4);
	    TreeNode q0 = test.new TreeNode(1, q11, q12);
		
        Print.stringOut("Is same tree?" + test.isSameTree(p0, q0));
	}
	/**
	 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
	 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
	 * 输入：p = [1,2,3], q = [1,2,3]
	 * 输出：true
	 * @param p
	 * @param q
	 * @return
	 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
         if (p == null || q ==null) {
             if (p == null && q == null) {
                 return true;
             } else {
                 return false;
             }
         }
         if (p.val == q.val) {
             return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
         } else {
             return false;
         }
    }
    /**
     * Definition for a binary tree node.
     * */
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
