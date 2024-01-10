package com.nikki.leetc.backtrack;
/**
 *单词搜索
 *@author:Jesse
 *@version:2023年12月6日下午11:36:03
**/
public class RTest79 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给定一个m x n二维字符网格board和一个字符串单词word。如果word存在于网格中，返回true；否则，返回false 。
	 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
	 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
	 * 输出：true
	 * 见笔记
	 * @param board
	 * @param word
	 * @return
	 */
    public boolean exist(char[][] board, String word) {
        //搜索单词转换成字符数组
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    /**
     * 
     * <pre>
     * </pre>
     *
     * @param board 二维字符矩阵
     * @param word 搜索单词
     * @param i 行
     * @param j 列
     * @param k 
     * @return
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //行超出矩阵高度、小于0、列超出矩阵宽度、小于0、搜索字符与word的字符不匹配
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        //搜索的为最后一个字符且匹配返回true
        if (k == word.length - 1) return true;
        //否则标记成已搜索
        board[i][j] = '\0';
        //上下右左分别搜索
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || 
                      dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        //写回word的字符
        board[i][j] = word[k];
        return res;
    }
}
