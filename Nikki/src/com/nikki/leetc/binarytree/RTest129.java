package com.nikki.leetc.binarytree;

import java.util.ArrayList;
import java.util.List;

import com.nikki.leetc.TreeNode;
import com.nikki.out.Print;

/**
 * 求根节点到叶节点数字之和
 *@author:Jesse
 *@version:2023年11月23日下午11:25:59
**/
public class RTest129 {

	public static void main(String[] args) {
		RTest129 test = new RTest129();
		Integer[] nums = {1,2,3};
        Print.stringOut("The sum is:" + test.sumNumbers(TreeNode.constructTree(nums)));
	}
	/**
	 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个0到9之间的数字。
	 * 每条从根节点到叶节点的路径都代表一个数字：
	 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字123 。
	 * 计算从根节点到叶节点生成的所有数字之和。
	 * 叶节点是指没有子节点的节点。
	 * 输入：root = [1,2,3]
	 * 输出：25
	 * 解释：
       从根到叶子节点路径 1->2 代表数字 12
       从根到叶子节点路径 1->3 代表数字 13
       因此，数字总和 = 12 + 13 = 25
	 * @param root
	 * @return
	 */
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        List<String> list = calPaths(root);
        for (String s: list) {
            sum = sum + Integer.valueOf(s);
        }
        return sum;
    }
    
    private List<String> calPaths(TreeNode root) {
        //创建列表保存遍历路径
        List<String> list = new ArrayList<String>();
        //根节点为null返回空列表
        if (root == null) return list;
        //计算左子树的遍历路径
        List<String> left = calPaths(root.left);
        for (String s: left) {
            StringBuffer sb = new StringBuffer("" + root.val);
            sb.append(s);
            list.add(sb.toString());
        }
        //计算右子树的遍历路径
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
