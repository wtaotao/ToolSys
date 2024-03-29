package com.nikki.leetc.math;

import java.util.HashMap;
import java.util.Map;

/**
 *直线上最多的点数
 *@author:Jesse
 *@version:2023年12月12日下午11:46:19
**/
public class RTest149 {

	public static void main(String[] args) {
		int[][] points = {{1,1},{2,2},{3,3}};
		

	}
	/**
	 * 给你一个数组points，其中points[i] = [xi, yi]表示X-Y平面上的一个点。求最多有多少个点在同一条直线上。
	 * 输入：points = [[1,1],[2,2],[3,3]]
     * 输出：3
	 * @param points
	 * @return
	 */
    public int maxPoints(int[][] points) {
        int n = points.length;
        //如果点数小于2，则直接返回总点数
        if (n <= 2) {
            return n;
        }
        //共线点数
        int ret = 0;
        //遍历每一个点
        for (int i = 0; i < n; i++) {
            if (ret >= n - i || ret > n / 2) {
                break;
            }
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }
            ret = Math.max(ret, maxn);
        }
        return ret;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
