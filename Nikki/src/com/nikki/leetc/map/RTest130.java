package com.nikki.leetc.map;

import com.nikki.out.Print;

/**
 * 被围绕的区域
 *@author:Jesse Wang
 *@version:2023年11月26日下午11:11:58
**/
public class RTest130 {

	public static void main(String[] args) {
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		solve(board);
        for (int i = 0; i < board.length; i++) {
            Print.arrayOut(board[i]);
        }
	}
	/**
	 * 给你一个m x n的矩阵board，由若干字符'X'和'O'，找到所有被'X'围绕的区域，并将这些区域里所有的'O'用'X'填充。
	 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
	 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
	 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。任何不在边界上，或不与边界上的'O'相连的'O'
	 * 最终都会被填充为'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
	 * @param board
	 */
    public static void solve1(char[][] board) {
    //思路：先找到在边界上的o，再递归找它相邻的0
        if (board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0  && i < m-1) && (j > 0 && j < n-1) && board[i][j] == 'X') {
                    //相邻的O置为X
                    if (board[i+1][j] == 'O') {
                        board[i+1][j] = 'X';
                    }
                }
                if ((i == m-1  && i > 1) && (j > 0 && j < n-1) && board[i][j] == 'X') {
                    //相邻的O置为X
                    if (board[i-1][j] == 'O') {
                        board[i-1][j] = 'X';
                    }
                }
                if ((j == 0  && j < n-1) && (i > 0 && i< m-1) && board[i][j] == 'X') {
                    if (board[i][j+1] == 'O') {
                        board[i][j+1] = 'X';
                    }
                }
                if ((j == n-1  && j > 1) && (i > 0 && i< m-1) && board[i][j] == 'X') {
                    if (board[i][j-1] == 'O') {
                        board[i][j-1] = 'X';
                    }
                }
            }
        }
    }
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从边缘o开始搜索
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length  || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            // board[i][j] == '#' 说明已经搜索过了. 
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j); // 上
        dfs(board, i + 1, j); // 下
        dfs(board, i, j - 1); // 左
        dfs(board, i, j + 1); // 右
    }
}
