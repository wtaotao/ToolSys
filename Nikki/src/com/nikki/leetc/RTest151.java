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
 * @author wangyanjun
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
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     * 1 <= s.length <= 104
     * s 包含英文大小写字母、数字和空格 ' '
     * s 中 至少存在一个 单词
     * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
     * </pre>
     *
     * @return
     */
    private static String reverse(String s) {
        StringBuffer reverseStrBf = new StringBuffer();
        int start = s.length() - 1;
        int end = s.length()-1;
        while (start >= 0 && end >= 0) {
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            };
            
            start = end;
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            };
            
            if (reverseStrBf.length() != 0 && start!= end) reverseStrBf.append(" ");
            reverseStrBf.append(s.substring(start+1, end+1));
            
            end = start;
        }
        
        return reverseStrBf.toString();
    }
}
