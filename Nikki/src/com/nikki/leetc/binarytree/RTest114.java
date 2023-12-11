package com.nikki.leetc.binarytree;

import com.nikki.leetc.TreeNode;
import com.nikki.out.Print;

/**
 * 二叉树展开为链表
 *@author:Jesse
 *@version:2023年11月22日下午11:47:00
**/
public class RTest114 {

	public static void main(String[] args) {
		Integer[] nums = {1,2,5,3,4,null,6};
		
		TreeNode tree = TreeNode.constructTree(nums);
		flatten(tree);
	      
	    Print.stringOut(tree.toString());
	}
	/**
	 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
	 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
	 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
	 * 输入：root = [1,2,5,3,4,null,6]
	 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
	 * @param root
	 */
    public static void flatten1(TreeNode root) {
        if (root != null) {
            if (root.left != null)
            {
                flatten1(root.left);
                root.left = root;
            }
            if (root.right != null) {
                flatten1(root.right);
            }
        }
    }
    public static void flatten(TreeNode root) {
        while (root != null) { 
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                } 
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }
}
