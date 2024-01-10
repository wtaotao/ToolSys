package com.nikki.leetc.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nikki.out.Print;

import java.util.HashMap;

/**
 * 电话号码的字母组合
 *@author:Jesse
 *@version:2023年11月26日下午11:44:50
**/
public class RTest17 {

	public static void main(String[] args) {
		String digits = "23";
		List<String> strs = letterCombinations(digits);
		for (String str: strs) {
		    Print.stringOut(str);
		}
	}
	/**
	 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
	 * 给出数字到字母的映射如下（与电话按键相同）。注意1不对应任何字母。
	 * 输入：digits = "23"
	 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
	 * @param digits
	 * @return
	 */
    public static List<String> letterCombinations(String digits) {
        //创建字符串列表存放结果
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        //映射map，用作查字典
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }
    /**
     * 
     * <pre>
     *
     * </pre>
     *
     * @param combinations 字符串列表存放结果
     * @param phoneMap 映射查询字典
     * @param digits 输入字符串
     * @param index 当前搜索字符下标
     * @param combination 结果串缓存
     */
    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        //若当前下标等于输入字符串长度，结果串插入结果列表
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            //获取字符串的单个字符
            char digit = digits.charAt(index);
            //查询单个字符对应的可能字符串
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            //遍历可能串，尝试每条路径
            for (int i = 0; i < lettersCount; i++) {
                //尝试放入当前字符
                combination.append(letters.charAt(i));
                //下标增1，递归调用生成整个串
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                //删除尝试的字符进行后面的尝试
                combination.deleteCharAt(index);
            }
        }
    }
}
