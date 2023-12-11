package com.nikki.leetc.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针II
 *@author:Jesse
 *@version:2023年11月22日下午11:44:09
**/
public class RTest117 {

	public static void main(String[] args) {
		RTest117 test = new RTest117();
        Integer[] root = {1,2,3,4,5,null,7};
        Node tree = test.constructTree(root);

	}
    private Node constructTree(Integer[] root) {
        Node tree = null;
        if (root == null || root[0] == null) return tree;
        //这个还不能用单纯的栈呢，得用双端队列
        Deque<Node> stack = new ArrayDeque<>(); 
        tree = new Node(root[0]);
        Node temp = tree;
//        stack.addFirst(tree);
        int count = 0;
        for (int i = 1; i < root.length; i++) {
            if (count == 2) {
                temp = stack.pollFirst();
                count = 0;
            }
            if (root[i] != null) {
                Node node = new Node(root[i]);
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
	 * 给定一个二叉树：
     struct Node {
       int val;
       Node *left;
       Node *right;
       Node *next;
     }
     * 填充它的每个next指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将next指针设置为NULL。
     * 初始状态下，所有next指针都被设置为NULL。
     * 输入：root=[1,2,3,4,5,null,7]
     * 输出：[1,#,2,3,#,4,5,7,#]
     * 解释：给定二叉树如图A所示，你的函数应该填充它的每个next指针，以指向其下一个右侧节点，如图B所示。
     * 序列化输出按层序遍历顺序（由next指针连接），'#' 表示每层的末尾。
	 * @param root
	 * @return
	 */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //队列暂存节点
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 1; i <= n; ++i) {
                Node f = queue.poll();
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i != 1) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }
 // Definition for a Node.
 class Node {
     public int val;
     public Node left;
     public Node right;
     public Node next;
     public Node() {}
     public Node(int _val) {
         val = _val;
     }
     public Node(int _val, Node _left, Node _right, Node _next) {
         val = _val;
         left = _left;
         right = _right;
         next = _next;
     }
 };
}
