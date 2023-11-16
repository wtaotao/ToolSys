package com.nikki.leetc.hash;

import com.nikki.out.Print;

/**
 * 快乐数
 * @author Jesse
 *
 */
public class RTest202 {

	public static void main(String[] args) {
		int n = 19;
		Print.stringOut("Is happy?" + isHappy(n));
	}
	/**
	 * 编写一个算法来判断一个数 n 是不是快乐数。
	 * 「快乐数」 定义为：
	 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
	 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
	 * 如果这个过程 结果为 1，那么这个数就是快乐数。
	 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false
	 * 输入：n = 19
	 * 输出：true
	 * 解释：
	 * 12 + 92 = 82
	 * 82 + 22 = 68
	 * 62 + 82 = 100
	 * 12 + 02 + 02 = 1
	 * @param n
	 * @return
	 */
	public static boolean isHappy(int n) {
		boolean isHappy = false;
		//到什么时候循环结束？暂时假定以10次
		int count = 10;
		//假定n最大为9999
		while (count > 0 || n != 1) {
		    int kilo = n/1000;
		    int hundreds = (n%1000)/100;
		    int tens = (n%100)/10;
		    int unit = n%10;
		    n = (int) (Math.pow(kilo, 2) + Math.pow(hundreds, 2) + Math.pow(tens, 2) + Math.pow(unit, 2));
		    count--;
		}
		if (n == 1) isHappy = true;
		return isHappy;
	}
}
