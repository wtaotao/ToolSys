package com.nikki.leetc.binarysearch;
/**
 *搜索旋转排序数组
 *@author:Jesse
 *@version:2023年12月11日下午11:23:56
**/
public class RTest33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 整数数组nums按升序排列，数组中的值互不相同。
	 * 在传递给函数之前，nums在预先未知的某个下标k（0 <= k < nums.length）上进行了旋转，使数组变为[nums[k], nums[k+1], ..., 
	 * nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标从0开始计数）。例如，[0,1,2,4,5,6,7] 在下标3处经旋转后可能变为
	 * [4,5,6,7,0,1,2]。
	 * 给你旋转后的数组nums和一个整数target，如果nums中存在这个目标值target，则返回它的下标，否则返回-1。
	 * 你必须设计一个时间复杂度为 O(log n)的算法解决此问题。
	 * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
	 * @param nums
	 * @param target
	 * @return
	 */
    public int search(int[] nums, int target) {
        int n = nums.length;
        //数组长度为0，则返回-1
        if (n == 0) {
            return -1;
        }
        //数组只有一个元素，直接跟目标值比较即可
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        //左右从数据头尾开始
        while (l <= r) {
            //取中间值
            int mid = (l + r) / 2;
            //中间值等于目标，直接返回
            if (nums[mid] == target) {
                return mid;
            }
            //首元素小于中间值
            if (nums[0] <= nums[mid]) {
                //目标值在前半部分，右标前移；在后半部分，左标后移
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                //首元素大于中间值
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
