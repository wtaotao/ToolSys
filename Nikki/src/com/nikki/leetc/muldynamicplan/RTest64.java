package com.nikki.leetc.muldynamicplan;
/**
 *最小路径和
 *@author:Jesse
 *@version:2023年12月13日下午10:44:19
**/
public class RTest64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给定一个包含非负整数的m x n网格grid，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
	 * 说明：每次只能向下或者向右移动一步。
	 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径1→3→1→1→1的总和最小。
	 * @param grid
	 * @return
	 */
    public int minPathSum(int[][] grid) {
        //思路：
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
