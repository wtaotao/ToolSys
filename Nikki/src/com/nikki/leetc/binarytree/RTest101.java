package com.nikki.leetc.binarytree;

import java.util.LinkedList;

import com.nikki.out.Print;

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
		Print.stringOut("Is symmetric?" + test.isSymmetric(p0));
	}
	/**
	 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
	 * 输入：root = [1,2,2,3,4,4,3]
	 * 输出：true
	 * @param root
	 * @return
	 */
    public boolean isSymmetric(TreeNode root) {
		if(root==null) {
			return true;
		}
		//调用递归函数，比较左节点，右节点
		return dfs(root.left,root.right);
    }
	boolean dfs(TreeNode left, TreeNode right) {
		//递归的终止条件是两个节点都为空
		//或者两个节点中有一个为空
		//或者两个节点的值不相等
		if(left==null && right==null) {
			return true;
		}
		if(left==null || right==null) {
			return false;
		}
		if(left.val!=right.val) {
			return false;
		}
		//再递归的比较 左节点的左孩子 和 右节点的右孩子
		//以及比较  左节点的右孩子 和 右节点的左孩子
		return dfs(left.left,right.right) && dfs(left.right,right.left);
	}
	public boolean isSymmetric1(TreeNode root) {
		if(root==null || (root.left==null && root.right==null)) {
			return true;
		}
		//用队列保存节点
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		//将根节点的左右孩子放到队列中
		queue.add(root.left);
		queue.add(root.right);
		while(queue.size()>0) {
			//从队列中取出两个节点，再比较这两个节点
			TreeNode left = queue.removeFirst();
			TreeNode right = queue.removeFirst();
			//如果两个节点都为空就继续循环，两者有一个为空就返回false
			if(left==null && right==null) {
				continue;
			}
			if(left==null || right==null) {
				return false;
			}
			if(left.val!=right.val) {
				return false;
			}
			//将左节点的左孩子， 右节点的右孩子放入队列
			queue.add(left.left);
			queue.add(right.right);
			//将左节点的右孩子，右节点的左孩子放入队列
			queue.add(left.right);
			queue.add(right.left);
		}
		return true;
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
