/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * <pre>
 * 罗马数字转整数
 * </pre>
 *
 * @author wangyanjun
 * @filename RTest.java
 * @version v0.1 2023年11月9日
 * @time 上午10:51:47 
 *
 */
public class RTest13 {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        String s = "III";
//        String s = "IV";
//        String s = "IX";
//        String s = "LVIII";
        String s = "MCMXCIV";
        Print.stringOut("The number is:" + romanToInt(s));
    }

    /**
     * 
     * <pre>
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如，罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 
     * 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 
     * </pre>
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int number = 0;
        for (int i=0; i < s.length(); i++) {
            if (i < s.length()-1) {
                String subStr = s.substring(i, i+2);
                if (subStr.equalsIgnoreCase("IV") || subStr.equalsIgnoreCase("IX") || subStr.equalsIgnoreCase("XL") || 
                        subStr.equalsIgnoreCase("XC") || subStr.equalsIgnoreCase("CD") || subStr.equalsIgnoreCase("CM")) {
                    number = number + transSpecial(subStr);
                    i++;
                    continue;
                }
            }
            number = number + transNormal(s.charAt(i));
        }
        return number;
    }
    
    private static int transNormal(char c) {
        int number = 0;
        switch(c) {
            case 'I': number = 1; break;
            case 'V': number = 5; break;
            case 'X': number = 10; break;
            case 'L': number = 50; break;
            case 'C': number = 100; break;
            case 'D': number = 500; break;
            case 'M': number = 1000; break;
            default: number = 0;
        }
        return number;
    }
    
    private static int transSpecial(String s) {
        int number = 0;
        if (s.length() == 2) {
            if (s.equalsIgnoreCase("IV")) {
                number = 4;
            } else if (s.equalsIgnoreCase("IX")) {
                number = 9;
            } else if (s.equalsIgnoreCase("XL")) {
                number = 40;
            } else if (s.equalsIgnoreCase("XC")) {
                number = 90;
            } else if (s.equalsIgnoreCase("CD")) {
                number = 400;
            } else if (s.equalsIgnoreCase("CM")) {
                number = 900;
            }
        }
        return number;
    }
}
