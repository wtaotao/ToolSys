package com.nikki.leetc.binarysearch;
/**
 *搜索二维矩阵
 *@author:Jesse
 *@version:2023年12月11日下午11:17:51
**/
public class RTest74 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个满足下述两条属性的 m x n 整数矩阵：
     * 每行中的整数从左到右按非严格递增顺序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 给你一个整数target，如果target在矩阵中，返回true；否则，返回false。
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
	 * @param matrix
	 * @param target
	 * @return
	 */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        //数组的首尾下标
        int low = 0, high = m * n - 1;
        while (low <= high) {
            //取中间点
            int mid = (high - low) / 2 + low;
            //获取到矩阵元素
            int x = matrix[mid / n][mid % n];
            //元素小于目标值，则后半部分查找
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                //否则，前半部分查找
                high = mid - 1;
            } else {
                //相等则找到了
                return true;
            }
        }
        return false;
    }
}
