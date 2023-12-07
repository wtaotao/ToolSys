package com.nikki.leetc.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.nikki.leetc.TreeNode;

/**
 * 从前序与中序遍历序列构造二叉树
 *@author:Jesse
 *@version:2023年11月22日下午11:39:54
**/
public class RTest105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
	 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
	 * 输出: [3,9,20,null,null,15,7]
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	//需参考思路
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int i = 0, j = 0;
        Stack<Integer> prestack = new Stack<Integer>();
        Stack<Integer> instack = new Stack<Integer>();
        TreeNode root = null;
        TreeNode top = null;
        boolean hasTop = false;
        while (i < preorder.length && j < inorder.length) {
            if (!hasTop) {
                if (preorder[i] == inorder[j]) {
                    top = new TreeNode(inorder[j]);
                    if (root == null) {
                        root = top;
                    }
                    hasTop = true;
                    i++;
                    j++;
                } else {
                    prestack.push(preorder[i]);
                    i++;
                }
            } else {
                if (prestack.peek() != null) {
                    int temp = prestack.pop();
                    if (temp == inorder[j]) {
                        TreeNode left = new TreeNode(inorder[j]);
                        top.left = left;
                        j++;
                    }
                }
            }
        }
        return root;
    }
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
