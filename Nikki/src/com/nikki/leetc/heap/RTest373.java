package com.nikki.leetc.heap;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

/**
 *查找和最小的 K 对数字 
 *@author:Jesse
 *@version:2023年12月11日下午11:33:47
**/
public class RTest373 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给定两个以非递减顺序排列的整数数组nums1和nums2, 以及一个整数k。
	 * 定义一对值 (u,v)，其中第一个元素来自nums1，第二个元素来自nums2。
	 * 请找到和最小的k个数对(u1,v1),(u2,v2)...(uk,vk)。
	 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
     * 输出: [1,2],[1,4],[1,6]
     * 解释: 返回序列中的前3对数：
     * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @return
	 */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i,0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }
        
        return ans;
    }
}
