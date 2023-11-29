/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * <pre>
 * 整数转罗马数字
 * </pre>
 *
 * @author Jesse Wang
 * @filename RTest12.java
 * @version v0.1 2023年11月10日
 * @time 上午9:59:05 
 *
 */
public class RTest12 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        int num = 3;
//        int num = 4;
//        int num = 9;
//        int num = 58;
        int num = 1994;
        Print.stringOut("The roman is:" + intToRoman(num));
    }
    /**
     * 
     * <pre>
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如，罗马数字2写做II，即为两个并列的1。12写做XII，即为X+II。27写做XXVII,即为XX+V+II。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如4不写做IIII，而是IV。数字1在数字5的左边，所表示的数等于大数5减小数1得到的数值4。
     * 同样地，数字9表示为IX。这个特殊的规则只适用于以下六种情况：
     * I可以放在V(5)和X(10)的左边，来表示4和9。
     * X可以放在L(50)和C(100)的左边，来表示40和90。
     * C可以放在D(500)和M(1000)的左边，来表示400和900。
     * 
     * 1 <= num <= 3999
     * </pre>
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        StringBuffer romanBuf = new StringBuffer(); 
        int kilo = num/1000;
        //千位转换
        for (int i=1; i<=kilo; i++) {
            romanBuf.append(transToRoman(1000));
        }
        //百位转换
        int handreds = (num%1000)/100;
        romanBuf.append(transToRoman(handreds*100));
        //十位转换
        int tens = (num%100)/10;
        romanBuf.append(transToRoman(tens*10));
        //个位转换
        int unit = num%10;
        romanBuf.append(transToRoman(unit));
        return romanBuf.toString();
    }
    
    private static String transToRoman(int n) {
        String roman = "";
        if (n<1 || n>3999) {
            return "";
        }
        switch(n)
        {
            case 1: roman = "I"; break;
            case 2: roman = "II"; break;
            case 3: roman = "III"; break;
            case 4: roman = "IV"; break;
            case 5: roman = "V"; break;
            case 6: roman = "VI"; break;
            case 7: roman = "VII"; break;
            case 8: roman = "VIII"; break;
            case 9: roman = "IX"; break;
            case 10: roman = "X"; break;
            case 20: roman = "XX"; break;
            case 30: roman = "XXX"; break;
            case 40: roman = "XL"; break;
            case 50: roman = "L"; break;
            case 60: roman = "LX"; break;
            case 70: roman = "LXX"; break;
            case 80: roman = "LXXX"; break;
            case 90: roman = "XC"; break;
            case 100: roman = "C"; break;
            case 200: roman = "CC"; break;
            case 300: roman = "CCC"; break;
            case 400: roman = "CD"; break;
            case 500: roman = "D"; break;
            case 600: roman = "DC"; break;
            case 700: roman = "DCC"; break;
            case 800: roman = "DCCC"; break;
            case 900: roman = "CM"; break;
            case 1000: roman = "M"; break;
//            case 2000: roman = "MM"; break;
            default: ;
        }
        return roman;
    }
}
