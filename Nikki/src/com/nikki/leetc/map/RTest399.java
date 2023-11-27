package com.nikki.leetc.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 除法求值
 *@author:Jesse
 *@version:2023年11月26日下午11:20:16
**/
public class RTest399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 
	 * 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
	 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
	 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
	 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
	 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
	 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
	 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
	 * 解释：
     * 条件：a / b = 2.0, b / c = 3.0
     * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
     * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
     * 注意：x 是未定义的 => -1.0
	 * 
	 * @param equations
	 * @param values
	 * @param queries
	 * @return
	 */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if (queries == null || queries.size() == 0 || equations.size() != values.length) {
            return null;
        }
        Map<String, Double> equa2val = new HashMap<String, Double>();
        StringBuffer fullStrSb = new StringBuffer();
        for (int i = 0; i < equations.size(); i++) {
            StringBuffer sb = new StringBuffer();
            for (String s: equations.get(i)) {
                sb.append(s);
                fullStrSb.append(s);
            }
            equa2val.put(sb.toString(), values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            boolean isFind = true;
            List<String> list =  queries.get(i);
            for (String s: list) {
                if (fullStrSb.indexOf(s) == -1) {
                    isFind = false;
                }
            }
            if (!isFind || list.size() != 2) {
                result[i] = -1;
                continue;
            }
            //存在则根据规则计算
            
        }
        return result;
    }
}
