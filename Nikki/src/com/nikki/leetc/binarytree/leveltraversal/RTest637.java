package com.nikki.leetc.binarytree.leveltraversal;

import java.util.ArrayList;
import java.util.List;

import com.nikki.leetc.TreeNode;
import com.nikki.out.Print;

/**
 * 二叉树的层平均值
 *@author:Jesse
 *@version:2023年11月26日下午11:00:46
**/
public class RTest637 {

	public static void main(String[] args) {
	    Integer[] root = {3,9,20,null,null,15,7};
		TreeNode tree = TreeNode.constructTree(root);

		RTest637 test = new RTest637();
		List<Double> list = test.averageOfLevels(tree);
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < list.size(); i++) {
		    if (i > 0) sb.append(",");
		    sb.append(list.get(i));
		}
		sb.append("]");
		Print.stringOut(sb.toString());
	}
	/**
	 * 给定一个非空二叉树的根节点root, 以数组的形式返回每一层节点的平均值。与实际答案相差10-5以内的答案可以被接受。
	 * 输入：root = [3,9,20,null,null,15,7]
	 * 输出：[3.00000,14.50000,11.00000]
	 * 解释：第0层的平均值为3,第1层的平均值为14.5,第2层的平均值为11。因此返回[3, 14.5, 11]。
	 * @param root
	 * @return
	 */
	   public List<Double> averageOfLevels(TreeNode root) {
	        List<Integer> counts = new ArrayList<Integer>();
	        List<Double> sums = new ArrayList<Double>();
	        //深度优先遍历
	        dfs(root, 0, counts, sums);
	        //平均值列表
	        List<Double> averages = new ArrayList<Double>();
	        int size = sums.size();
	        for (int i = 0; i < size; i++) {
	            averages.add(sums.get(i) / counts.get(i));
	        }
	        return averages;
	    }
        /**
         * 
         * <pre>
         *
         * </pre>
         *
         * @param root 根节点
         * @param level 层
         * @param counts 个数
         * @param sums 和
         */
	    public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
	        if (root == null) {
	            return;
	        }
	        if (level < sums.size()) {
	            //逐个累加某层节点值计算和
	            sums.set(level, sums.get(level) + root.val);
	            //逐个累加计算某层节点个数
	            counts.set(level, counts.get(level) + 1);
	        } else {
	            //根节点，计算总和，个数增一
	            sums.add(1.0 * root.val);
	            counts.add(1);
	        }
	        dfs(root.left, level + 1, counts, sums);
	        dfs(root.right, level + 1, counts, sums);
	    }
}
