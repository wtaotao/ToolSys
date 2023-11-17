package com.nikki.leetc.section;

import java.util.ArrayList;
import java.util.List;

import com.nikki.out.Print;

/**
 * 合并区间
 * @author Jesse
 *
 */
public class RTest56 {

	public static void main(String[] args) {
	    int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
	    int[][] merge = (new RTest56()).merge(intervals);
	    for (int i = 0; i < merge.length; i++) {
	        Print.arrayOut(merge[i]);
	    }

	}
	/**
	 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 
	 * 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
	 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
	 * 输出：[[1,6],[8,10],[15,18]]
	 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
	 * @param intervals
	 * @return
	 */
	public int[][] merge(int[][] intervals) {
		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
		//假定输入的数组是有序的起始坐标逐步增加的
		for (int i = 0; i < intervals.length; i++) {
		    int start = intervals[i][0];
		    int end = intervals[i][1];
		    for (int j = i+1; j < intervals.length; j++) {
		        if (end >= intervals[j][0]) {
		            end = intervals[j][1];
		        } else {
		            Pair<Integer, Integer> pair = new Pair<Integer, Integer>(start, end);
		            list.add(pair);
		            i = j-1;
		            break;
		        }
		    }
		    if (i == intervals.length-1) {
		        Pair<Integer, Integer> pair = new Pair<Integer, Integer>(start, end);
		        list.add(pair);
		    }
		}
		int[][] merge = new int[list.size()][2];
		int i = 0;
		for (Pair<Integer, Integer> pair: list) {
		    merge[i][0] = pair.getFirst();
		    merge[i][1] = pair.getSecond();
		    i++;
		}
		return merge;
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
