package com.nikki.leetc.math;

import java.util.Stack;

import com.nikki.out.Print;

/**
 *回文数
 *@author:Jesse
 *@version:2023年12月12日下午11:37:41
**/
public class RTest9 {

	public static void main(String[] args) {
		int x = -121;
		Print.stringOut("Is palindrome?" + isPalindrome(x));
	}
	/**
	 * 给你一个整数x，如果x是一个回文整数，返回true；否则，返回false。
	 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	 * 例如，121是回文，而123不是。
	 * 输入：x = 121
     * 输出：true
	 * @param x
	 * @return
	 */
    public static boolean isPalindrome(int x) {
        //思路：每位上的数压入堆栈，弹出时按位乘以10，判断结果是不是跟原数相等
        int tx = Math.abs(x);
        Stack<Integer> stack = new Stack<Integer>();
        //从个位至高位，依次压入位数值
        while (tx != 0) {
            stack.push(tx%10);
            tx = tx/10;
        }
        int tp = 0;
        //数位的算子
        int operator = 1;
        while (!stack.empty()) {
            //从高位至低位依次弹出，同时乘以位算子（个位->高位）求和
        	tp = tp + operator*stack.pop();
        	operator = 10*operator;
        }
        return tp == Math.abs(x);
    }
}
