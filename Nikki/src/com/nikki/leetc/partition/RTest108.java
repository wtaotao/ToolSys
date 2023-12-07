package com.nikki.leetc.partition;

import com.nikki.leetc.TreeNode;

/**
 *将有序数组转换为二叉搜索树
 *@author:Jesse
 *@version:2023年12月6日下午11:41:24
**/
public class RTest108 {

	public static void main(String[] args) {
	    RTest108 test = new RTest108();
		int[] nums = {-10,-3,0,5,9};
		TreeNode tree = test.sortedArrayToBST(nums);
        TreeNode.print(tree);
	}
	/**
	 * 给你一个整数数组nums，其中元素已经按升序排列，请你将其转换为一棵高度平衡二叉搜索树。
	 * 高度平衡二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过1」的二叉树。
	 * 输入：nums = [-10,-3,0,5,9]
	 * 输出：[0,-3,9,-10,null,5]
	 * 解释：[0,-10,5,null,-3,null,9]也将被视为正确答案
	 * @param nums
	 * @return
	 */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head = null;
        if (nums == null || nums.length == 0) {
            return head;
        }
        int mid = (int) Math.ceil(nums.length/2.0) - 1;
        head = new TreeNode(nums[mid]);
        head.left = constructTree(nums, 0, mid-1);
        head.right = constructTree(nums, mid+1, nums.length-1);
        return head;
    }
    
    private TreeNode constructTree(int[] nums, int start, int end) {
        
        if (start < 0 || end > nums.length-1 || start > end) {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(nums, start, mid-1);
        root.right = constructTree(nums, mid+1, end);
        return root;
    }
}
