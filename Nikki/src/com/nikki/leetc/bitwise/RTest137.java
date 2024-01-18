package com.nikki.leetc.bitwise;

import java.util.HashMap;
import java.util.Map;

/**
 *只出现一次的数字 II
 *@author:Jesse
 *@version:2023年12月11日下午11:43:15
**/
public class RTest137 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个整数数组nums，除某个元素仅出现一次外，其余每个元素都恰出现三次。请你找出并返回那个只出现了一次的元素。
	 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
	 * 输入：nums = [2,2,3,2]
     * 输出：3
	 * @param nums
	 * @return
	 */
    public int singleNumber(int[] nums) {
        //遍历并记录每个元素出现的次数。
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        //查找并输出出现次数为1的元素。改进：上面也可以第三次时删除那个元素，最后只剩下出现一次的。
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }
}
