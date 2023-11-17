package com.nikki.leetc.matrix;

import com.nikki.out.Print;

/**
 * 生命游戏
 * @author Jesse
 *
 */
public class RTest289 {

	public static void main(String[] args) {
		int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		gameOfLife(board);
		for (int i = 0; i < board.length; i++) {
		    Print.arrayOut(board[i]);
		}
	}
	/**
	 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
	 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），
	 * 或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
	 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
	 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
	 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
	 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
	 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 
	 * board 的当前状态，返回下一个状态。
	 * 输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
	 * 输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
	 * @param board
	 */
	public static void gameOfLife(int[][] board) {
	    //假定输入不为空
	    int M = board.length;
	    int N = board[0].length;
	    int[][] temp = new int[M][N];
	    for (int i = 0; i < M; i++) {
	        for (int j = 0; j < N; j++) {
	            temp[i][j] = board[i][j];
	        }
	    }
		for (int i = 0; i < M; i++) {
		    for (int j = 0; j < N; j++) {
		        int number = count(temp, i, j);
		        if (temp[i][j] == 1) {
		            if (number < 2) {
		                board[i][j] = 0;
		            } else if (number == 2 || number == 3) {
		                board[i][j] = 1;
		            } else if (number > 3) {
		                board[i][j] = 0;
		            }
		        } else if (temp[i][j] == 0) {
		            if (number == 3) {
		                board[i][j] = 1;
		            }
		        }
		    }
		}
	}
	
	private static int count(int[][] board, int i, int j) {
	    int count = 0;
	    //上面一行
	    if (i-1 >= 0) {
	        if (j-1 >= 0 && board[i-1][j-1] == 1) count++;
	        if (board[i-1][j] == 1) count++;
	        if (j+1 < board[0].length && board[i-1][j+1] == 1) count++;
	    }
	    //本行
	    if (j-1 >= 0 && board[i][j-1] == 1) count++;
	    if (j+1 < board[0].length && board[i][j+1] == 1) count++;
	    //下面一行
	    if (i+1 < board.length) {
	        if (j-1 >= 0 && board[i+1][j-1] == 1) count++;
	        if (board[i+1][j] == 1) count++;
	        if (j+1 < board[0].length && board[i+1][j+1] == 1) count++;
	    }
	    return count;
	}
}
