/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * <pre>
 * 反转字符串中的单词
 * </pre>
 *
 * @author Jesse Wang
 * @filename RTest151.java
 * @version v0.1 2023年11月10日
 * @time 下午3:46:56 
 *
 */
public class RTest151 {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        String s = "the sky is blue";
//        String s = "  hello world  ";
        String s = "a good   example";
        Print.stringOut("The reverse string is:" + reverse(s));
    }
    /**
     * 
     * <pre>
     * 给你一个字符串s，请你反转字符串中单词的顺序。
     * 单词是由非空格字符组成的字符串。s中使用至少一个空格将字符串中的单词分隔开。
     * 返回单词顺序颠倒且单词之间用单个空格连接的结果字符串。
     * 注意：输入字符串s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     * 1 <= s.length <= 104
     * s包含英文大小写字母、数字和空格' '
     * s中至少存在一个单词
     * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用O(1)额外空间复杂度的原地解法。
     * </pre>
     *
     * @return
     */
    private static String reverse(String s) {
        StringBuffer reverseStrBf = new StringBuffer();
        int start = s.length() - 1;
        int end = s.length()-1;
        while (start >= 0 && end >= 0) {
            //从字符串末尾逆向搜索至第一个非空字符
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            };
            
            start = end;
            //start指针逆向搜索至第一个空字符
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            };
            //搜索未结束且不是第一个word，则插入一个空格
            if (reverseStrBf.length() != 0 && start!= end) reverseStrBf.append(" ");
            //插入搜索到的单词
            reverseStrBf.append(s.substring(start+1, end+1));
            //尾指针设置到开始指针处，继续下一个word的查找
            end = start;
        }
        
        return reverseStrBf.toString();
    }
}
