package com.nikki.leetc.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * @author Jesse
 *
 */
public class RTest54 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
	 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
	 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int u = 0, d = m - 1, l = 0, r = n - 1;
        while (true) {
            for (int i = l; i <= r; i ++) res.add(matrix[u][i]);
            if (++u > d) break;
            for (int i = u; i <= d; i ++) res.add(matrix[i][r]);
            if (--r < l) break;
            for (int i = r; i >= l; i --) res.add(matrix[d][i]);
            if (--d < u) break;
            for (int i = d; i  >= u; i --) res.add(matrix[i][l]);
            if (++l > r) break;
        }
        return res;
	}
}
