package com.nikki.leetc.binarytree;

import java.util.ArrayList;
import java.util.List;

import com.nikki.leetc.TreeNode;

/**
 * 二叉搜索树迭代器
 *@author:Jesse
 *@version:2023年11月23日下午11:30:17
**/
public class RTest173 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * Your BSTIterator object will be instantiated and called as such:
	 * BSTIterator obj = new BSTIterator(root);
	 * int param_1 = obj.next();
	 * boolean param_2 = obj.hasNext();
	 */
	/**
	 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
	 * 
	 * @author Jesse
	 *
	 */
	class BSTIterator {
	    private int idx;
	    private List<Integer> arr;
        /**
         * BSTIterator(TreeNode root)初始化
         * BSTIterator类的一个对象。BST的根节点root会作为构造函数的一部分给出。指针应初始化为一个不存在于BST中的数字，且该数字小于BST 
         * 中的任何元素
         * 
         * @param root
         */
	    public BSTIterator(TreeNode root) {
	        idx = 0;
	        arr = new ArrayList<Integer>();
	        inorderTraversal(root, arr);
	    }
	    /**
	     * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
	     * @return
	     */
	    public int next() {
	        return arr.get(idx++);
	    }
	    /**
	     * int next()将指针向右移动，然后返回指针处的数字。
	     * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
	     * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
	     * @return
	     */
	    public boolean hasNext() {
	        return idx < arr.size();
	    }
	    private void inorderTraversal(TreeNode root, List<Integer> arr) {
	        if (root == null) {
	            return;
	        }
	        inorderTraversal(root.left, arr);
	        arr.add(root.val);
	        inorderTraversal(root.right, arr);
	    }
	}
}
