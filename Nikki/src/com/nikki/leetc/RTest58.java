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
//        String s = "luffy is still joyboy";
        String s = "day";
        Print.stringOut("The length of last word is:" + lengthOfLastWord(s));
    }
    /**
     * 
     * <pre>
     * 给你一个字符串s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
     * 单词是指仅由字母组成、不包含任何空格字符的最大子字符串。
     * 1 <= s.length <= 104
     * s 仅有英文字母和空格' '组成
     * s 中至少存在一个单词
     * </pre>
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        //假定s不为空且不为空格串
    	if (s.trim().length() == 1) return 1;    	
        int lastLength = 0;
        //从最后一个字符逆向搜索，过滤掉空格至第一个字符
        int end = s.length()-1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        };
        //从末尾搜索至最后一个单词的开始
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        };
        
        //start多前移一个元素
        lastLength = end -start;
        return lastLength;
    }
}
