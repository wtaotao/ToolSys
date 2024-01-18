package com.nikki.leetc.binarytree.leveltraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.nikki.leetc.TreeNode;
import com.nikki.out.Print;

/**
 * 二叉树的右视图
 *@author:Jesse
 *@version:2023年11月26日下午10:58:58
**/
public class RTest199 {

	public static void main(String[] args) {
		Integer[] root = {1,2,3,null,5,null,4};
		TreeNode tree = TreeNode.constructTree(root);
		
        RTest199 test = new RTest199();
        List<Integer> rightView = test.rightSideView(tree);
        Print.printList(rightView);
	}
	/**
	 * 给定一个二叉树的根节点root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
	 * 输入: [1,2,3,null,5,null,4]
	 * 输出: [1,3,4]
	 * @param root
	 * @return
	 */
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        //节点栈
        Deque<TreeNode> nodeStack = new LinkedList<TreeNode>();
        //深度栈
        Deque<Integer> depthStack = new LinkedList<Integer>();
        //根节点入栈
        nodeStack.push(root);
        depthStack.push(0);
        //栈中有节点则按个弹出处理
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
            	// 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入（每层最后一个压入的节点会最先弹出并放到map）
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }
                //先左节点再右节点压入堆栈，最先弹出来的会是最右节点
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        //根据深度挨个取出最右的节点
        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }
        return rightView;
    }
}
