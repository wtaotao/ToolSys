package com.nikki.leetc.bitwise;

import java.util.HashMap;
import java.util.Map;

/**
 *只出现一次的数字
 *@author:Jesse
 *@version:2023年12月11日下午11:42:18
**/
public class RTest136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个非空整数数组nums，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
	 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
	 * 输入：nums = [2,2,1]
     * 输出：1
	 * @param nums
	 * @return
	 */
    public int singleNumber(int[] nums) {
        //利用hashmap，对所有值进行计数
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        //输出计数为1的key。改进：利用其余每个元素出现两次这点，上面计数时，若没查到，就放进去；查到即删除；
        //遍历结束时hashmap中正好只有出现一次的元素
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }
}
