package com.nikki.leetc.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器
 * @author Jesse
 *
 */
public class RTest224 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
	 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
	 * 输入：s = "1 + 1"
	 * 输出：2
	 * @param s
	 * @return
	 */
	public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}
