/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * <pre>
 * 最长公共前缀
 * </pre>
 *
 * @author Jesse Wang
 * @filename RTest14.java
 * @version v0.1 2023年11月10日
 * @time 下午1:59:41 
 *
 */
public class RTest14 {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"dog","racecar","car"};
//        String[] strs = {"ab", "a"};
        String[] strs = {"flower","flower","flower","flower"};
        Print.stringOut("The longest prefix is:" + longestCommonPrefix(strs));
    }
    /**
     * 
     * <pre>
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串""。
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     * </pre>
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int index = 0;
        String prefix = "";
        if (strs[0].length() < 1) return "";
        do {
            char c = strs[0].charAt(index);
            int i=1;
            for (; i<strs.length; i++) {
                if ((index >= strs[i].length()) || (index < strs[i].length()) && (strs[i].charAt(index) != c) ) {
                    break;
                }
            }
            if (i == strs.length) {
                index++;
            } else {
                break;
            }
        } while (index < strs[0].length());
        if (index > 0) prefix = strs[0].substring(0, index);
        return prefix;
    }
}
