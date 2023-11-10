/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * <pre>
 *
 * </pre>
 *
 * @author wangyanjun
 * @filename RTest58.java
 * @version v0.1 2023年11月10日
 * @time 下午1:08:16 
 *
 */
public class RTest58 {
    public static void main(String[] args) {
//        String s = "Hello World";
//        String s = "   fly me   to   the moon  ";
        String s = "luffy is still joyboy";
        Print.stringOut("The length of last word is:" + lengthOfLastWord(s));
    }
    /**
     * 
     * <pre>
     * 给你一个字符串s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个单词的长度。
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     * 1 <= s.length <= 104
     * s 仅有英文字母和空格 ' ' 组成
     * s 中至少存在一个单词
     * </pre>
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        int lastLength = 0;
        
        int end = s.length()-1;
        while (s.charAt(end) == ' ' && end > 0) {
            end--;
        };
        
        int start = end;
        while (s.charAt(start) != ' ' && start > 0) {
            start--;
        };
        
        //start多前移一个元素
        lastLength = end -start;
        return lastLength;
    }
}
