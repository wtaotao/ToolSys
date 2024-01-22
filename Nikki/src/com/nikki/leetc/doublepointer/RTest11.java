package com.nikki.leetc.doublepointer;

import com.nikki.out.Print;

/**
 * 盛最多水的容器
 * @author Jesse
 *
 */
public class RTest11 {

	public static void main(String[] args) {
//		int[] height = {1,8,6,2,5,4,8,3,7};
		int[] height = {1,2};
		Print.stringOut("The max is : " + maxArea1(height));
	}
	/**
	 * 给定一个长度为n的整数数组height。有n条垂线，第i条线的两个端点是(i, 0)和(i, height[i])。
	 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
	 * 返回容器可以储存的最大水量。
	 * 说明：你不能倾斜容器。
	 * 输入：[1,8,6,2,5,4,8,3,7]
	 * 输出：49
	 * 解释：图中垂直线代表输入数组[1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
	 * @param height
	 * @return
	 */
	public static int maxArea1(int[] height) {
	    /**
	     * 思路：遍历每个height，找到离它距离最远的那个不小于它的height的距离；如果都比它小，则记为0；最后输出最大水量
	     */
	    int max = 0;
	    //只有一根以下的直线，则装不了水
	    if (height.length <= 1) return max;
	    for (int i=0; i<height.length; i++) {
	        int submax = 0;
	        //i不变，移动j，搜索当前的最大值
	        for (int j=0; j<height.length; j++) {
	            if(i == j) continue;
	            if (height[j] >= height[i]) {
	                int temp = Math.abs(j-i)*height[i];
	                if (temp > submax) {
	                    submax = temp;
	                }
	            }
	        }
	        if (submax > max) {
	            max = submax;
	        }
	    }
		
	    return max;
	}
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        //从两边往中间搜索
        while(i < j) {
            //i高度比j高度低，计算当前的蓄水量并更新最大值，i前移；否则j后移
            res = height[i] < height[j] ? 
                Math.max(res, (j - i) * height[i++]): 
                Math.max(res, (j - i) * height[j--]); 
        }
        return res;
    }
}
