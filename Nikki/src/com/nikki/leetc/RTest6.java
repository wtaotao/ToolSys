package com.nikki.leetc;

import java.util.ArrayList;
import java.util.List;

import com.nikki.out.Print;

/**
 * N 字形变换
 * @author Jesse
 *
 */
public class RTest6 {

	public static void main(String[] args) {
//		String s = "PAYPALISHIRING";
//		int numRows = 3;
		String s = "PAYPALISHIRING";
		int numRows = 4;
		Print.stringOut("The convert string is:" + convert(s, numRows));

	}
	/**
	 * 将一个给定字符串s根据给定的行数numRows，以从上往下、从左到右进行Z字形排列。
	 * 比如输入字符串为 "PAYPALISHIRING" 行数为3时，排列如下：
	 * P   A   H   N
	 * A P L S I I G
	 * Y   I   R
	 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
	 * 请你实现这个将字符串进行指定行数变换的函数：
	 * string convert(string s, int numRows);
	 *  
	 * @param s
	 * @param numRows
	 * @return
	 */
    public static String convert(String s, int numRows) {
    	//行数为1，直接返回
        if(numRows < 2) return s;
        //初始化字符串列表
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
