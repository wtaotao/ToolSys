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
	 * 给你二叉树的根节点root，返回其节点值的层序遍历。（即逐层地，从左到右访问所有节点）。
	 * 输入：root = [3,9,20,null,null,15,7]
	 * 输出：[[3],[9,20],[15,7]]
	 * @param root
	 * @return
	 */
    public List<List<Integer>> levelOrder(TreeNode root) {
        //创建队列按层保存节点
        List<List<Integer>> res = new ArrayList<>();
        //创建队列缓存遍历的父节点
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            //记录上一层的缓存节点个数，依次遍历
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) { 
                //取出并遍历每一个节点并把子节点入队列
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
