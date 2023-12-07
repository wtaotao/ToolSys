/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import java.util.ArrayDeque;
import java.util.Queue;

import com.nikki.out.Print;

/**
 * <pre>
 * Definition for a binary tree node.
 * </pre>
 *
 * @author wangyanjun
 * @filename TreeNode.java
 * @version v0.1 2023年11月28日
 * @time 下午2:59:50 
 *
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
           }
    public static TreeNode constructTree (Integer[] root) {
        if (root == null || root.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode rnode = new TreeNode(root[0]);
        queue.add(rnode);
        
        int n = root.length, i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            boolean hasLeft = false, hasRight = false;
            for (; i < n; ) {
                //创建新节点
                Integer val = root[i];
                TreeNode newNode = null;
                if (val != null) {
                    newNode = new TreeNode(val);
                    queue.add(newNode);
                }
                //设置为父节点的子节点
                if (!hasLeft) {
                    node.left = newNode;
                    hasLeft = true;
                    i++;
                } else if (!hasRight) {
                    node.right = newNode;
                    hasRight = true;
                    i++;
                    //跳出，取下一个父节点
                    break;
                }
            }
        }
        return rnode;
    }
    //假设节点值不为最大整数值
    public static void print(TreeNode tree) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        boolean validLevel = false;
        if (tree != null) {
            queue.add(tree);
            validLevel = true;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while (!queue.isEmpty() && validLevel) {
            int n = queue.size();
            validLevel = false;
            for (int i = 0; i < n; i++) {
                TreeNode top = queue.poll();
                if (sb.length() > 1) {
                    sb.append(",");
                }
                if (top.val != Integer.MAX_VALUE) {
                    sb.append(top.val);
                    //左右子节点不为空则入队列
                    if (top.left != null) {
                        queue.add(top.left);
                        validLevel = true;
                    } else {
                        queue.add(new TreeNode(Integer.MAX_VALUE));
                    }
                    if (top.right != null) {
                        queue.add(top.right);
                        validLevel = true;
                    } else {
                        queue.add(new TreeNode(Integer.MAX_VALUE));
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        sb.append("]");
        Print.stringOut(sb.toString());
    }
}
