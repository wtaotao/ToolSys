package com.nikki.leetc.backtrack;

import java.util.HashSet;
import java.util.Set;

import com.nikki.out.Print;

/**
 *N皇后II
 *@author:Jesse
 *@version:2023年12月6日下午11:28:28
**/
public class RTest52 {

	public static void main(String[] args) {
		RTest52 test = new RTest52();
        int n = 4;
        Print.stringOut(n + " queens problem's solution number is:" + test.totalNQueens(n));
	}
	/**
	 * n皇后问题研究的是如何将n个皇后放置在n × n的棋盘上，并且使皇后彼此之间不能相互攻击。
	 * 给你一个整数n，返回n皇后问题不同的解决方案的数量。
	 * 见笔记
	 * @param n
	 * @return
	 */
    public int totalNQueens(int n) {
        //创建列集合、左斜集合、右斜集合
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        return backtrack(n, 0, columns, diagonals1, diagonals2);
    }
    /**
     * 
     * <pre>
     *
     * </pre>
     *
     * @param n 皇后个数
     * @param row 行标
     * @param columns 列集合
     * @param diagonals1 左斜集合
     * @param diagonals2 右斜集合
     * @return
     */
    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        //若行标等于皇后数，则只有一种方案
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            //n皇后逐个遍历
            for (int i = 0; i < n; i++) {
                //若本皇后已在列集合中，则跳到下一轮
                if (columns.contains(i)) {
                    continue;
                }
                //检查左斜集合是否已有皇后，每条斜线行列之差相等
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                //检查右斜集合是否已有皇后，每条斜线行列之和相等
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                //加入列集合、左斜集合和右斜集合
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                //进行下一行搜索尝试
                count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                //移除前面的尝试
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }
}
