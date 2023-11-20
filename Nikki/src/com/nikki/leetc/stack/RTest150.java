package com.nikki.leetc.stack;

import com.nikki.out.Print;

/**
 * 逆波兰表达式求值
 * @author Jesse
 *
 */
public class RTest150 {

	public static void main(String[] args) {
		String[] tokens = {"2","1","+","3","*"};
		Print.stringOut("The result is :" + evalRPN(tokens));

	}
	/**
	 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
	 * 请你计算该表达式。返回一个表示表达式值的整数。
	 * 注意：
	 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
	 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
	 * 两个整数之间的除法总是 向零截断 。
	 * 表达式中不含除零运算。
	 * 输入是一个根据逆波兰表示法表示的算术表达式。
	 * 答案及所有中间计算结果可以用 32 位 整数表示。
	 * 输入：tokens = ["2","1","+","3","*"]
	 * 输出：9
	 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
	 * 
	 * @param tokens
	 * @return
	 */
	public static int evalRPN(String[] tokens) {
		int result = 0;
		if (tokens == null || tokens.length < 3) {
		    return -1;
		}
		int optl = Integer.valueOf(tokens[0]);
		int optr = Integer.valueOf(tokens[1]);
		String operator = tokens[2];
		int i = 2;
		while (i < tokens.length) {
		    switch(operator) {
		        case "+" : result = optl + optr; break;
		        case "-" : result = optl - optr; break;
		        case "*" : result = optl * optr; break;
		        case "/" : result = optl / optr; break;
		        default : result = -1;
		    }
		    if (result == -1) {
		        return result;
		    }
		    if (i == tokens.length -1 ) {
		        break;
		    }
		    if ( i + 2 < tokens.length) {
		        optl = result;
		        optr = Integer.valueOf(tokens[i+1]);
		        operator = tokens[i+2];
		        i = i + 2;
		    } else {
		        result = -1;
		        break;
		    }
		}
		return result;
	}
}
