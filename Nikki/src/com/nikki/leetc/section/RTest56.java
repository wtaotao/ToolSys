package com.nikki.leetc.section;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
	//case错误
	//intervals =[[1,4],[4,5]]
	//预期[[1,5]]		
	public int[][] merge1(int[][] intervals) {
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
	    public int[][] merge(int[][] intervals) {
	        if (intervals.length == 0) {
	            return new int[0][2];
	        }
	        Arrays.sort(intervals, new Comparator<int[]>() {
	            public int compare(int[] interval1, int[] interval2) {
	                return interval1[0] - interval2[0];
	            }
	        });
	        List<int[]> merged = new ArrayList<int[]>();
	        for (int i = 0; i < intervals.length; ++i) {
	            int L = intervals[i][0], R = intervals[i][1];
	            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
	                merged.add(new int[]{L, R});
	            } else {
	                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
	            }
	        }
	        return merged.toArray(new int[merged.size()][]);
	    }
}
