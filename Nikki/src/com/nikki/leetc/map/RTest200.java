package com.nikki.leetc.map;
/**
 * 岛屿数量
 *@author:Jesse
 *@version:2023年11月26日下午11:09:23
**/
public class RTest200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
	 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
	 * 此外，你可以假设该网格的四条边均被水包围。
	 * 输入：grid = [
  	 * ["1","1","1","1","0"],
  	 * ["1","1","0","1","0"],
  	 * ["1","1","0","0","0"],
  	 * ["0","0","0","0","0"]
	 * ]
	 * 输出：1
	 * 提示
	 * m == grid.length
	 * n == grid[i].length
	 * 1 <= m, n <= 300
	 * grid[i][j] 的值为 '0' 或 '1'
	 * @param grid
	 * @return
	 */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
    //网格深度遍历
    void dfs(int[][] grid, int r, int c) {
        // 判断 base case
        // 如果坐标 (r, c) 超出了网格范围，直接返回
        if (!inArea(grid, r, c)) {
            return;
        }
        // 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    // 判断坐标 (r, c) 是否在网格中
    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length 
            	&& 0 <= c && c < grid[0].length;
    }
}
