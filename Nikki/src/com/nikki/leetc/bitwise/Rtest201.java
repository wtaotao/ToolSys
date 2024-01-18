package com.nikki.leetc.bitwise;
/**
 *数字范围按位与
 *@author:Jesse
 *@version:2023年12月11日下午11:44:09
**/
public class Rtest201 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你两个整数left和right，表示区间[left, right] ，返回此区间内所有数字按位与的结果（包含left 、right端点）。
	 * 输入：left = 5, right = 7
     * 输出：4
	 * @param left
	 * @param right
	 * @return
	 */
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // 找到公共前缀
        while (left < right) {
        	left >>= 1;
            right >>= 1;
            ++shift;
        }
        return left << shift;
    }
}
