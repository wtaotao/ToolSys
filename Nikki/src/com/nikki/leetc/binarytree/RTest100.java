package com.nikki.leetc.binarytree;

import com.nikki.leetc.TreeNode;
import com.nikki.out.Print;

/**
 * 相同的树
 *@author:Jesse
 *@version:2023年11月21日下午11:50:21
**/
public class RTest100 {

	public static void main(String[] args) {
	    RTest100 test = new RTest100();
	    
	    Integer[] p = {1,2,3};
	    TreeNode tp = TreeNode.constructTree(p);

	    Integer[] q = {1,2,3};
	    TreeNode tq = TreeNode.constructTree(q);
		
        Print.stringOut("Is same tree?" + test.isSameTree(tp, tq));
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
        //若有一个比较节点为空
         if (p == null || q ==null) {
             //二者均为null则相同
             if (p == null && q == null) {
                 return true;
             } else {
                 //否则不同
                 return false;
             }
         }
         //节点值相等，则比较左子树和右子树
         if (p.val == q.val) {
             return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
         } else {
             return false;
         }
    } 
}
