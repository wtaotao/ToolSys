package com.nikki.leetc.backtrack;

import java.util.HashSet;
import java.util.Set;

/**
 *N皇后II
 *@author:Jesse
 *@version:2023年12月6日下午11:28:28
**/
public class RTest52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * n皇后问题研究的是如何将n个皇后放置在n × n的棋盘上，并且使皇后彼此之间不能相互攻击。
	 * 给你一个整数n，返回n皇后问题不同的解决方案的数量。
	 * 见笔记
	 * @param n
	 * @return
	 */
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        return backtrack(n, 0, columns, diagonals1, diagonals2);
    }

    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }
}
