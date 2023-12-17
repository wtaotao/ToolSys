package com.nikki.leetc.muldynamicplan;
/**
 *最大正方形
 *@author:Jesse
 *@version:2023年12月13日下午10:59:48
**/
public class RTest221 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 在一个由'0'和'1'组成的二维矩阵内，找到只包含'1'的最大正方形，并返回其面积。
	 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
	 * "1","0","1","0","0"
     * "1","0","1","1","1"
     * "1","1","1","1","1"
     * "1","0","0","1","0"
     * 输出：4
	 * @param matrix
	 * @return
	 */
    public int maximalSquare(char[][] matrix) {
        // base condition

        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;



        int height = matrix.length;

        int width = matrix[0].length;

        int maxSide = 0;



        // 相当于已经预处理新增第一行、第一列均为0

        int[][] dp = new int[height + 1][width + 1];



        for (int row = 0; row < height; row++) {

            for (int col = 0; col < width; col++) {

                if (matrix[row][col] == '1') {

                    dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;

                    maxSide = Math.max(maxSide, dp[row + 1][col + 1]);

                }

            }

        }

        return maxSide * maxSide;
    }
}
