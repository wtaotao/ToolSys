package com.nikki.leetc.muldynamicplan;
/**
 *不同路径 II
 *@author:Jesse
 *@version:2023年12月13日下午10:47:25
**/
public class RTest63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 一个机器人位于一个m x n网格的左上角（起始点在下图中标记为“Start”）。
	 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
	 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
	 * 网格中的障碍物和空位置分别用1和0来表示。
	 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：2
     * 解释：3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
	 * @param obstacleGrid
	 * @return
	 */
	int count = 0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //思路：可以用回溯，各个方向尝试
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        
        return f[m - 1];
    }
}
