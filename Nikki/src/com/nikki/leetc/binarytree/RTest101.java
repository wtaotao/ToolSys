package com.nikki.leetc.binarytree;

import java.util.LinkedList;

import com.nikki.leetc.TreeNode;
import com.nikki.out.Print;

/**
 * 对称二叉树
 *@author:Jesse
 *@version:2023年11月21日下午11:53:06
**/
public class RTest101 {

	public static void main(String[] args) {
		RTest101 test = new RTest101();
		
		Integer[] root = {1,2,2,3,4,4,null}; 
		TreeNode tree = TreeNode.constructTree(root);
		
		Print.stringOut("Is symmetric?" + test.isSymmetric1(tree));
	}
	/**
	 * 给你一个二叉树的根节点root，检查它是否轴对称。
	 * 输入：root = [1,2,2,3,4,4,3]
	 * 输出：true
	 * @param root
	 * @return
	 */
    public boolean isSymmetric(TreeNode root) {
        //根节点为空返回true
		if(root==null) {
			return true;
		}
		//调用递归函数，比较左节点，右节点
		return dfs(root.left,root.right);
    }
    /**
     * 
     * <pre>
     * 深度优先遍历
     * </pre>
     *
     * @param left
     * @param right
     * @return
     */
	boolean dfs(TreeNode left, TreeNode right) {
		//递归的终止条件是两个节点都为空
		if(left==null && right==null) {
			return true;
		}
		//或者两个节点中有一个为空
		if(left==null || right==null) {
			return false;
		}
		//或者两个节点的值不相等
		if(left.val!=right.val) {
			return false;
		}
		//再递归的比较 左节点的左孩子 和 右节点的右孩子
		//以及比较  左节点的右孩子 和 右节点的左孩子
		return dfs(left.left,right.right) && dfs(left.right,right.left);
	}
	//非递归方法
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
}
