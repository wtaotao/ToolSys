package com.nikki.leetc.binarytree.leveltraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nikki.leetc.ListNode;
import com.nikki.leetc.TreeNode;
import com.nikki.out.Print;

/**
 * 二叉树的锯齿形层序遍历
 *@author:Jesse
 *@version:2023年11月26日下午11:03:47
**/
public class RTest103 {

	public static void main(String[] args) {
		Integer[] root = {3,9,20,null,null,15,7};
        TreeNode tree = TreeNode.constructTree(root);
        
        RTest103 test = new RTest103();
        List<List<Integer>> list = test.zigzagLevelOrder(tree);
        Print.printLists(list);
	}
	/**
	 * 给你二叉树的根节点root，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
	 * 输入：root = [3,9,20,null,null,15,7]
	 * 输出：[[3],[20,9],[15,7]]
	 * @param root
	 * @return
	 */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //创建结果队列存放遍历节点
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
        //根节点入队列
        nodeQueue.offer(root);
        //标志位控制从左到右还是从右到左
        boolean isOrderLeft = true;
        //队列不为空时逐个弹出进行处理
        while (!nodeQueue.isEmpty()) {
            //每层创建一个列表保存
            Deque<Integer> levelList = new LinkedList<Integer>();
            //记录遍历层的节点个数
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                //取出队首元素
                TreeNode curNode = nodeQueue.poll();
                //在输出的每层次的队列中进行节点排序
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                //左节点入队列
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                //右节点入队列
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            //本层节点入列表
            ans.add(new LinkedList<Integer>(levelList));
            //转换方向
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }
}
