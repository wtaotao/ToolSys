package com.nikki.leetc.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.nikki.leetc.TreeNode;

/**
 * 二叉树的最近公共祖先
 *@author:Jesse
 *@version:2023年11月23日下午11:35:30
**/
public class RTest236 {

	public static void main(String[] args) {
	    RTest236 test = new RTest236();
		Integer[] root = {3,5,1,6,2,0,8,null,null,7,4};
		TreeNode tree = test.constructTree(root);

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
	 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
	 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
	 * （一个节点也可以是它自己的祖先）。”
	 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
	 * 输出：3
	 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
    //思路：流出所有的从根到叶子节点的全路径，找出含两个节点的全路径，第一个节点的前一个节点即为最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = null;
        List<String> paths = calPaths(root);
        String path = null, prefix = null;
        for (String s: paths) {
            if (s.contains("" + p.val) && s.contains("" + q.val)) {
                path = s;
                break;
            }
        }
        if (path != null) {
            int min = Math.min(path.indexOf("" + p.val), path.indexOf("" + q.val));
            prefix = path.substring(0, min);
        }
        for (int i = 0; i < prefix.length(); i++) {
            while ()
        }
        return node;
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
}
