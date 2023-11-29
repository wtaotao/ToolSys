package com.nikki.leetc.binarytree.leveltraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.nikki.leetc.TreeNode;
import com.nikki.out.Print;

/**
 * 二叉树的层序遍历
 *@author:Jesse
 *@version:2023年11月26日下午11:02:21
**/
public class RTest102 {

	public static void main(String[] args) {
	    RTest102 test = new RTest102();
		Integer[] root = {3,9,20,null,null,15,7};
		TreeNode tree = TreeNode.constructTree(root);

		List<List<Integer>> lists = test.levelOrder(tree);
		Print.printLists(lists);
	}
	/**
	 * 给你二叉树的根节点 root ，返回其节点值的层序遍历 。 （即逐层地，从左到右访问所有节点）。
	 * 输入：root = [3,9,20,null,null,15,7]
	 * 输出：[[3],[9,20],[15,7]]
	 * @param root
	 * @return
	 */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) { 
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}
