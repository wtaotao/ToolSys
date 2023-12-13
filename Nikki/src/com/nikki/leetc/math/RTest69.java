package com.nikki.leetc.math;

import com.nikki.out.Print;

/**
 * x 的平方根
 *@author:Jesse
 *@version:2023年12月12日下午11:44:01
**/
public class RTest69 {

	public static void main(String[] args) {
		int x = 16;
		Print.stringOut("The res is:" + mySqrt(x));

	}
	/**
	 * 给你一个非负整数x，计算并返回x的算术平方根 。
	 * 由于返回类型是整数，结果只保留整数部分，小数部分将被舍去。
	 * 注意：不允许使用任何内置指数函数和算符，例如pow(x, 0.5)或者x**0.5。
	 * 输入：x = 4
     * 输出：2
	 * @param x
	 * @return
	 */
    public static int mySqrt1(int x) {
        //思路：反过来以乘法找到逼近值
        int val = 0;
        int max = x;
        for (int i = max; i > 0; i--) {
            if (i*i <= x) {
                val = i;
                break;
            }
        }
        return val;
    }
    
 int s;
    
 public int mySqrt(int x) {
     s=x;
     if(x==0) return 0;
    return ((int)(sqrts(x)));
  }
    
    public double sqrts(double x){
      double res = (x + s / x) / 2;
    if (res == x) {
      return x;
    } else {
      return sqrts(res);
    }
    } 
}
