package com.nikki.leetc.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.nikki.out.Print;

/**
 * 矩阵置零
 * @author Jesse
 *
 */
public class RTest73 {

	public static void main(String[] args) {
//		int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		(new RTest73()).setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
		    Print.arrayOut(matrix[i]);
		}
	}
	/**
	 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
	 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
	 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
	 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
	 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {
	    List<Pair> list = new ArrayList<Pair>();
	    int M = matrix.length;
	    int N = matrix[0].length;
	    
		for (int i = 0; i < M; i++) {
		    for (int j = 0; j < N; j++) {
		        if (matrix[i][j] == 0) {
		            Pair<Integer, Integer> pair = new Pair<>(i, j);
		            list.add(pair);
		        }
		    }
		}
		
		for (Pair pair: list) {
		    int column = (int) pair.getSecond();
		    for (int i = 0; i < M; i++) {
		        matrix[i][column] = 0;
		    }
		    for (int j = 0; j < N; j++) {
		        matrix[(int) pair.getFirst()][j] = 0;
		    }
		}
		
	}
	public class Pair<T, U> {
	    private T first;
	    private U second;

	    public Pair(T first, U second) {
	        this.first = first;
	        this.second = second;
	    }

	    public T getFirst() {
	        return first;
	    }

	    public U getSecond() {
	        return second;
	    }

	    public void setFirst(T first) {
	        this.first = first;
	    }

	    public void setSecond(U second) {
	        this.second = second;
	    }
	}
}
