package com.nikki.leetc.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.nikki.out.Print;

/**
 * 求根节点到叶节点数字之和
 *@author:Jesse
 *@version:2023年11月23日下午11:25:59
**/
public class RTest129 {

	public static void main(String[] args) {
		RTest129 test = new RTest129();
		Integer[] nums = {1,2,3};
        Print.stringOut("The sum is:" + test.sumNumbers(test.constructTree(nums)));
	}
    private TreeNode constructTree(Integer[] root) {
        TreeNode tree = null;
        if (root == null || root[0] == null) return tree;
        //这个还不能用单纯的栈呢，得用双端队列
        Deque<TreeNode> stack = new ArrayDeque<>(); 
        tree = new TreeNode(root[0]);
        TreeNode temp = tree;
        int count = 0;
        for (int i = 1; i < root.length; i++) {
            if (count == 2) {
                temp = stack.pollFirst();
                count = 0;
            }
            if (root[i] != null) {
                TreeNode node = new TreeNode(root[i]);
                if (count == 0) {
                    temp.left = node;
                    count++;
                } else if (count == 1) {
                    temp.right = node;
                    count++;
                }
                stack.addLast(node);
            } else {
                count++;
            }
        }
        
        return tree;
    }
	/**
	 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
	 * 每条从根节点到叶节点的路径都代表一个数字：
	 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
	 * 计算从根节点到叶节点生成的 所有数字之和 。
	 * 叶节点 是指没有子节点的节点。
	 * 输入：root = [1,2,3]
	 * 输出：25
	 * 解释：
       从根到叶子节点路径 1->2 代表数字 12
       从根到叶子节点路径 1->3 代表数字 13
       因此，数字总和 = 12 + 13 = 25
	 * @param root
	 * @return
	 */
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        List<String> list = calPaths(root);
        for (String s: list) {
            sum = sum + Integer.valueOf(s);
        }
        return sum;
    }
    
    private List<String> calPaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if (root == null) return list;
        List<String> left = calPaths(root.left);
        for (String s: left) {
            StringBuffer sb = new StringBuffer("" + root.val);
            sb.append(s);
            list.add(sb.toString());
        }
        List<String> right = calPaths(root.right);
        for (String s: right) {
            StringBuffer sb = new StringBuffer("" + root.val);
            sb.append(s);
            list.add(sb.toString());
        }
        if (list.size() == 0) list.add("" + root.val);
        return list;
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
