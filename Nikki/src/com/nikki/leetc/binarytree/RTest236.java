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
	 * 百度百科中最近公共祖先的定义为：“对于有根树T的两个节点p、q，最近公共祖先表示为一个节点x，满足x是p、q的祖先且x的深度尽可能大
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
    //定义一棵结果树
    private TreeNode ans;
    //获取p、q最近的祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        //若节点为空，则返回false
        if (root == null) return false;
        //左子树遍历
        boolean lson = dfs(root.left, p, q);
        //右子树遍历
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        } 
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            //只要当前根节点是p和q中的任意一个，就返回（因为不能比这个更深了，再深p和q中的一个就没了）
            return root;
        }
        //根节点不是p和q中的任意一个，那么就继续分别往左子树和右子树找p和q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //p和q都没找到，那就没有
        if(left == null && right == null) {
            return null;
        }
        //左子树没有p也没有q，就返回右子树的结果
        if (left == null) {
            return right;
        }
        //右子树没有p也没有q就返回左子树的结果
        if (right == null) {
            return left;
        }
        //左右子树都找到p和q了，那就说明p和q分别在左右两个子树上，所以此时的最近公共祖先就是root
        return root;
    }
}
