package com.nikki.leetc.binarysearch;
/**
 *寻找两个正序数组的中位数
 *@author:Jesse
 *@version:2023年12月11日下午11:28:43
**/
public class RTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给定两个大小分别为m和n的正序（从小到大）数组nums1和nums2。请你找出并返回这两个正序数组的中位数。
	 * 算法的时间复杂度应该为 O(log (m+n)) 。
	 * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
	 * @param nums1
	 * @param nums2
	 * @return
	 */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //计算两个数组的总长度
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        //如果总长度为奇数，中间下标即为2的商
        if (totalLength % 2 == 1) {
            int midIndex = totalLength/2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength/2 - 1, midIndex2 = totalLength/2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }
    /**
     * 
     * <pre>
     *
     * </pre>
     *
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @param k 中间数序号
     * @return
     */
    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第k(k>1)小的元素，那么就取pivot1 = nums1[k/2-1]和pivot2 = nums2[k/2-1]进行比较
         * 这里的 "/" 表示整除
         * nums1中小于等于pivot1的元素有nums1[0 .. k/2-2]共计k/2-1个
         * nums2中小于等于pivot2的元素有nums2[0 .. k/2-2]共计k/2-1个
         * 取pivot = min(pivot1, pivot2)，两个数组中小于等于pivot的元素共计不会超过(k/2-1) + (k/2-1) <= k-2 个
         * 这样pivot本身最大也只能是第k-1小的元素
         * 如果pivot = pivot1，那么nums1[0 .. k/2-1]都不可能是第k小的元素。把这些元素全部"删除"，剩下的作为新的nums1数组
         * 如果pivot = pivot2，那么nums2[0 .. k/2-1]都不可能是第k小的元素。把这些元素全部"删除"，剩下的作为新的nums2数组
         * 由于我们"删除"了一些元素（这些元素都比第k小的元素要小），因此需要修改k的值，减去删除的数的个数
         */
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            
            // 正常情况
            int half = k / 2;
            //取数组长度和起点+半中间序号的较小值
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            //设置新的数组中间取值
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            //若数组1的值较小，则可以删除数组1前面的值
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
