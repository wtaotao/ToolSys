/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc.binarytree.leveltraversal;

import java.util.ArrayDeque;
import java.util.Queue;

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
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
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
}
