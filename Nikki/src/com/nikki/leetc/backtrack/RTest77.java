package com.nikki.leetc.backtrack;

import java.util.ArrayList;
import java.util.List;

import com.nikki.out.Print;

/**
 *组合
 *@author:Jesse
 *@version:2023年11月26日下午11:46:44
**/
public class RTest77 {

	public static void main(String[] args) {
		int n = 4, k = 2;
		List<List<Integer>> combinations = combine(n, k);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < combinations.size(); j++) {
            List<Integer> list = combinations.get(j);
            if (j == 0) {
                sb.append("[");
            }
            if (j > 0) {
                sb.append(",");
            }
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    sb.append("[").append(list.get(i));
                } else {
                    sb.append(",").append(list.get(i));
                }
                if (i == list.size()-1) {
                    sb.append("]");
                }
            }
            if (j == combinations.size()-1) {
                sb.append("]");
            }
        }
        Print.stringOut(sb.toString());
	}
	/**
	 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
	 * 你可以按 任何顺序 返回答案。
	 * 输入：n = 4, k = 2
	 * 输出：
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
	 * @param n
	 * @param k
	 * @return
	 */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if (n < k || k <= 0) {
            return combinations;
        }
        backtrack(n, k, 0, combinations, new ArrayList<Integer>());
        return combinations;
    }
    
    private static void backtrack(int n, int k, int index, List<List<Integer>> combinations, List<Integer> list) {
        if (k == index) {
            List<Integer> tempList = new ArrayList<Integer>();
            tempList.addAll(list);
            combinations.add(tempList);
        } else {
            for (int i = 0; i < n; i++) {
                if (!list.contains(i+1) && (list.isEmpty() || list.get(list.size()-1) < i+1)) {
                    list.add(i+1);
                    backtrack(n, k, index+1, combinations, list);
                    list.remove(index);
                }
            }
        }
    }
}
