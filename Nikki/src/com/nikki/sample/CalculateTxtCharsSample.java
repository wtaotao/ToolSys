/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 *
 * </pre>
 *
 * @author wangyanjun
 * @version $Id: CalculateTxtChars.java, v 0.1 2023年9月4日 下午1:05:51 wangyanjun Exp $
 */
public class CalculateTxtCharsSample {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final String filePath = "C:\\Users\\wangyanjun\\Desktop\\tt\\sql\\meta_dict_item_202307031938.sql";
//        final String filePath = "C:\\Users\\wangyanjun\\Desktop\\tt\\1.txt";
        
        System.out.println("The Chinese character's count is " + countTxtChinese(filePath));
        
    }
    
    private static int countTxtChinese(String filePath) {
        int sum = 0;
        String tt;
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while((tt = reader.readLine()) != null) {
                // unicode的中文编码表,第一个“4e200”,最后一个“9fa5”
//                Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
                Pattern p = Pattern.compile("[0-9]");
                Matcher m = p.matcher(tt);
                while(m.find()) {
                    sum++;
                }
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return sum;
    }

}
