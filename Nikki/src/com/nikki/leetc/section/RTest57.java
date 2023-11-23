package com.nikki.leetc.section;

import java.util.ArrayList;
import java.util.List;

/**
 * 插入区间
 * @author Jesse
 *
 */
public class RTest57 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个无重叠的，按照区间起始端点排序的区间列表。
	 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
	 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
	 * 输出：[[1,5],[6,9]]
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 * case错误
	 * intervals =[[1,3],[6,9]]
	 * newInterval = [2,5]
	 */
	public int[][] insert1(int[][] intervals, int[] newInterval) {
	    if (intervals == null || intervals.length < 1) {
	        return null;
	    }
	    if (newInterval == null || newInterval.length < 1) {
	        return intervals;
	    }
	    int[][] outputs = new int[intervals.length + 1][2];
	    int left = 0, right = 0, index = 0;
	    boolean merged = false;
		for (int i = 0; i < intervals.length; i++) {
		    int[] temp = intervals[i];
		    if (newInterval[0] < temp[0]) {
		       left = newInterval[0]; 
		       if (newInterval[1] < temp[0]) {
		           right = newInterval[1];
		           outputs[index] = new int[]{left, right};
		           index++;
		           merged = true;
		       } else {
		           if (newInterval[1] <= temp[1]) {
		               right = temp[1];
		               outputs[index] = new int[]{left, right};
		               index++;
		               merged = true;
		           }
		       }
		       
		    } else {
		        left = temp[0];
		    }
		    
		}
		return outputs;
	}
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;                    
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
