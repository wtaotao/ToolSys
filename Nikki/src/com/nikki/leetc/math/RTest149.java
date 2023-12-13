package com.nikki.leetc.math;
/**
 *直线上最多的点数
 *@author:Jesse
 *@version:2023年12月12日下午11:46:19
**/
public class RTest149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
	 * 输入：points = [[1,1],[2,2],[3,3]]
     * 输出：3
	 * @param points
	 * @return
	 */
    public int maxPoints(int[][] points) {
        //思路：可在水平线、垂直线、斜线, 前后两个点相减算斜率，斜率相同的在一条线上？
        if (points == null) {
            return 0;
        } else if (points.length <= 2) {
            return points.length;
        }
        //总点数多于2，则计算斜率
        
        return 0;
    }
}
