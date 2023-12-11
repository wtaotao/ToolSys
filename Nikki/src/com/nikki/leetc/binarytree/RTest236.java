package com.nikki.leetc.binarytree;

import java.util.ArrayList;
import java.util.List;

import com.nikki.leetc.TreeNode;
import com.nikki.out.Print;

/**
 * 二叉树的最近公共祖先
 *@author:Jesse
 *@version:2023年11月23日下午11:35:30
**/
public class RTest236 {

	public static void main(String[] args) {
	    RTest236 test = new RTest236();
		Integer[] root = {3,5,1};
//		Integer[] root = {3,5,1,6,2,0,8,null,null,7,4};
		TreeNode tree = TreeNode.constructTree(root);
		int p = 5, q = 1;
		TreeNode node = test.lowestCommonAncestor(tree, tree.left, tree.right);
		Print.stringOut("The lowest common ancestor is:" + node.val);
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
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
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
//            while ()
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
    //官方解法
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        } 
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}
