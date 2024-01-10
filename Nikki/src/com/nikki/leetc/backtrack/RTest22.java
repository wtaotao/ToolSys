package com.nikki.leetc.backtrack;

import java.util.ArrayList;
import java.util.List;

import com.nikki.out.Print;

/**
 *括号生成 
 *@author:Jesse
 *@version:2023年12月6日下午11:34:02
**/
public class RTest22 {

	public static void main(String[] args) {
		RTest22 test = new RTest22();
		List<String> list = test.generateParenthesis(6);
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (String s: list) {
		    //非第一个串之前需要输出逗号
		    if (sb.length() > 1) {
		        sb.append(",");
		    }
		    sb.append("\"").append(s).append("\"");
		}
		sb.append("]");
		Print.stringOut(sb.toString());
	}
	/**
	 * 数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
	 * 输入：n = 3
	 * 输出：["((()))","(()())","(())()","()(())","()()()"]
	 * @param n
	 * @return
	 */
    public List<String> generateParenthesis(int n) {
        //创建字符串列表存放结果
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    /**
     * 
     * <pre>
     *
     * </pre>
     *
     * @param ans 字符串结果列表
     * @param cur 当前字符串缓存
     * @param open 开括号
     * @param close 闭括号
     * @param max 括号对数
     */
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        //若当前字符串长度为括号对数两倍，则插入字符串结果列表返回
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        //开括号个数小于括号对数
        if (open < max) {
            //尝试插入开括号
            cur.append('(');
            //递归生成开括号+1的可能串
            backtrack(ans, cur, open + 1, close, max);
            //删除尝试的开括号
            cur.deleteCharAt(cur.length() - 1);
        }
        //若闭括号少于开括号数
        if (close < open) {
            //尝试插入闭括号
            cur.append(')');
            //递归生成闭括号+1的可能串
            backtrack(ans, cur, open, close + 1, max);
            //删除尝试的闭括号
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
