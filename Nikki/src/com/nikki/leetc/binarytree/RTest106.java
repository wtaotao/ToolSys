package com.nikki.leetc.binarytree;

import java.util.HashMap;
import java.util.Map;

import com.nikki.leetc.TreeNode;

/**
 * 从中序与后序遍历序列构造二叉树
 *@author:Jesse
 *@version:2023年11月22日下午11:42:18
**/
public class RTest106 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给定两个整数数组inorder和postorder，其中inorder是二叉树的中序遍历，postorder是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
	 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
	 * 输出：[3,9,20,null,null,15,7]
	 * @param inorder
	 * @param postorder
	 * @return
	 */
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        //从后序遍历的最后一个元素开始，最后一个元素是根节点
        post_idx = postorder.length - 1;
        
        //建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        
        return helper(0, inorder.length - 1);
    }
    /**
     * 
     * <pre>
     *
     * </pre>
     *
     * @param in_left 中序遍历数组左标
     * @param in_right 中序遍历数组右标
     * @return
     */
    public TreeNode helper(int in_left, int in_right) {
        //如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }
        //选择post_idx位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        // 根据root所在位置分成左右两棵子树
        int index = idx_map.get(root_val);
        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }
}
