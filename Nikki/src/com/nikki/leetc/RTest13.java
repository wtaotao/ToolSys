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
 * @author Jesse Wang
 * @filename RTest.java
 * @version v0.1 2023年11月9日
 * @time 上午10:51:47 
 *
 */
public class RTest13 {

    /**
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
     * 罗马数字包含以下七种字符: I，V，X，L，C，D和M。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如，罗马数字2写做II，即为两个并列的1。12写做XII，即为X+II。27写做XXVII,即为XX+V+II。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如4不写做IIII，而是IV。数字1在数字5的左边，所表示的数等于大数5 
     * 减小数1得到的数值4。同样地，数字9表示为IX。这个特殊的规则只适用于以下六种情况：
     * I可以放在V(5)和X(10)的左边，来表示4和9。
     * X可以放在L(50)和C(100)的左边，来表示40和90。
     * C可以放在D(500)和M(1000)的左边，来表示400和900。
     * </pre>
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int number = 0;
        for (int i=0; i < s.length(); i++) {
            //特殊转换涉及连续两个字符
            if (i < s.length()-1) {
                String subStr = s.substring(i, i+2);
                if (subStr.equalsIgnoreCase("IV") || subStr.equalsIgnoreCase("IX") || subStr.equalsIgnoreCase("XL") || 
                        subStr.equalsIgnoreCase("XC") || subStr.equalsIgnoreCase("CD") || subStr.equalsIgnoreCase("CM")) {
                    number = number + transSpecial(subStr);
                    //指针多向后移动一位
                    i++;
                    continue;
                }
            }
            //普通转换只涉及单个字符
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
