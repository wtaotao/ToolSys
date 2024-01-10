package com.nikki.leetc.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 组合总和
 *@author:Jesse
 *@version:2023年12月6日下午11:26:08
**/
public class RTest39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	/**
	 * 你一个无重复元素的整数数组candidates和一个目标整数target，找出candidates中可以使数字和为目标数target的所有不同组合，
	 * 并以列表形式返回。你可以按任意顺序返回这些组合。
	 * candidates中的同一个数字可以无限制重复被选取。如果至少一个数字的被选数量不同，则两种组合是不同的。
	 * 对于给定的输入，保证和为target的不同组合数少于150个。
	 * 输入：candidates = [2,3,6,7], target = 7
	 * 输出：[[2,2,3],[7]]
	 * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意2可以使用多次。
     * 7 也是一个候选，7 = 7 。
     * 仅有这两种组合。
	 * @param candidates
	 * @param target
	 * @return
	 */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //创建结果列表
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        //备选数列表为空则返回空结果列表
        if (len == 0) {
            return res;
        }
        //排序是剪枝的前提
        Arrays.sort(candidates);
        //创建缓存队列
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }
    /**
     * 
     * <pre>
     *
     * </pre>
     *
     * @param candidates 可选数集合
     * @param begin 开始下标
     * @param len 长度
     * @param target 目标值
     * @param path 路径队列
     * @param res 结果列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        //由于进入更深层的时候，小于0的部分被剪枝，因此递归终止条件值只判断等于0的情况
        if (target == 0) {
            //若正好等于目标值，则插入本路径进结果集
            res.add(new ArrayList<>(path));
            return;
        }
        //从起点开始遍历整个候选数组
        for (int i = begin; i < len; i++) {
            //重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }
            //如果不大于剩余目标值，加入候选值
            path.addLast(candidates[i]);
            //递归在减去已选候选值的情况下进行新一轮尝试
            dfs(candidates, i, len, target - candidates[i], path, res);
            //删除候选值，进行其它尝试
            path.removeLast();
        }
    }
}
