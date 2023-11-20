package com.nikki.leetc.stack;

import java.util.Stack;

import com.nikki.out.Print;

/**
 * 有效的括号
 * @author Jesse
 *
 */
public class RTest20 {

	public static void main(String[] args) {
//		String s = "()";
//		String s = "()[]{}";
		String s = "]";
		Print.stringOut("Is valid?" + isValid(s));
	}
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * 输入：s = "()"
     * 输出：true
     * 输入：s = "()[]{}"
     * 输出：true
     * @param s
     * @return
     */
	public static boolean isValid(String s) {
	    boolean valid = false;
	    Stack<Character> stack = new Stack<Character>();
	    for (int i = 0; i < s.length(); i++) {
	        switch (s.charAt(i)) {
	            case '(' : stack.push(s.charAt(i)); break;
	            case ')' : {
	                if (!stack.isEmpty() && stack.peek() == '(') {
	                    stack.pop();
	                    break;
	                } else {
	                    return valid;
	                }
	            }
	            case '{' : stack.push(s.charAt(i)); break;
	            case '}' :  {
	                if (!stack.isEmpty() && stack.peek() == '{') {
	                    stack.pop();
	                    break;
	                } else {
	                    return valid;
	                }
	            }
	            case '[' : stack.push(s.charAt(i)); break;
	            case ']' :  {
	                if (!stack.isEmpty() && stack.peek() == '[') {
	                    stack.pop();
	                    break;
	                } else {
	                    return valid;
	                }
	            }
	            default : return valid;
	        }
	    }
	    if (stack.isEmpty()) {
	        valid = true;
	    }
		return valid;
	}
}
