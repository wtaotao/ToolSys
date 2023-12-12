package com.nikki.leetc.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

import com.nikki.out.Print;

/**
 *IPO
 *@author:Jesse
 *@version:2023年12月11日下午11:32:16
**/
public class RTest502 {

	public static void main(String[] args) {
		int k = 2, w = 0;
		int[] profits = {1,2,3};
		int[] capital = {0,1,1};
		
		RTest502 test = new RTest502();
		Print.stringOut("The max capital is:" + test.findMaximizedCapital(k, w, profits, capital));
	}
	/**
	 * 假设力扣（LeetCode）即将开始IPO。为了以更高的价格将股票卖给风险投资公司，力扣希望在IPO之前开展一些项目以增加其资本。由于资源有限，
	 * 它只能在IPO之前完成最多k个不同的项目。帮助力扣设计完成最多k个不同项目后得到最大总资本的方式。
	 * 给你n个项目。对于每个项目i，它都有一个纯利润profits[i]，和启动该项目需要的最小资本capital[i]。
	 * 最初，你的资本为w。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
	 * 总而言之，从给定项目中选择最多k个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。
	 * 答案保证在32位有符号整数范围内。
	 * 输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
	 * 输入：k = 10, w = 0, profits = [1,2,3], capital = [0,1,2] 预期6
     * 输出：4
     * 解释：
     * 由于你的初始资本为 0，你仅可以从0号项目开始。
     * 在完成后，你将获得1的利润，你的总资本将变为1。
     * 此时你可以选择开始1号或2号项目。
     * 由于你最多可以选择两个项目，所以你需要完成2号项目以获得最大的资本。
     * 因此，输出最后最大化的资本，为0 + 1 + 3 = 4。
	 * @param k
	 * @param w
	 * @param profits
	 * @param capital
	 * @return
	 */
    public int findMaximizedCapital1(int k, int w, int[] profits, int[] capital) {
        //思路：根据初始资本，在capital里选择可启动的项目，选择利润最高的；把利润加入最终资本，再以前面的逻辑选择下一个项目；直至完成最多的项目，返回最终的资本。
        int max = 0;
        if (capital == null || profits == null || capital.length != profits.length || k > capital.length) {
            return max;
        }
        for (int i = 0; i < k; i++) {
            max = max + selectMaxCapProject(w, profits, capital);
            w = max;
        }
        return max;
    }
    
    private int selectMaxCapProject(int w, int[] profits, int[] capital) {
        int max = 0, index = -1;
        for (int i = 0; i < capital.length; i++) {
            if (w >= capital[i] && profits[i] > max) {
                max = profits[i];
                index = i;
            }
        }
        if (index >= 0) {
            capital[index] = Integer.MAX_VALUE;
            profits[index] = 0;
        }
        return max;
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; ++i) {
            while (curr < n && arr[curr][0] <= w) {
                pq.add(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }

        return w;
    }
}
