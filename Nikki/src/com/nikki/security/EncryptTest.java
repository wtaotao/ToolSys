package com.nikki.security;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

import com.nikki.constant.WeekDay;

public class EncryptTest {

    private static final String MD5_SALT = "QAZWSXEDCRFV09876543210";

    public static void main(String[] args) {
        String str = "reqData={\"series\":\"\",\"deliveryStart\":\"\",\"deliveryEnd\":\"\",\"lockStatus\":\"\",\"storageStart\":\"\",\"currentPage\":\"1\",\"vehicleVtatus\":\"0\",\"model\":\"\",\"warehouseId\":\"\",\"brand\":\"\",\"announceYear\":\"\",\"standardColorId\":\"\",\"storageEnd\":\"\",\"qualityStatus\":\"\",\"pageNumber\":\"10\",\"vin\":\"\"},\"userId\":\"505\",\"token\":\"cf792647-7780-492e-b36b-ad38dd4ab8d3\",\"time\":\"1508830541000\"&time=1508830541000&token=cf792647-7780-492e-b36b-ad38dd4ab8d3";
        //
        // System.out.println("The index of week day 'Monday' is " + WeekDay.MONDAY.getIndex());
        // String str = "a,b,c,,"; String[] ary = str.split(","); //预期大于 3，结果是 3
        // System.out.println(ary.length);
//         System.out.println(System.currentTimeMillis());
//         encrypt("ANJIJIAJIA_CUSTOMER_2");
//         encrypt("ANJIJIAJIA_KEY_XXXXXX2");
//         encrypt("reqData={\"damageId\":\"278\",\"type\":0,\"vehicleId\":\"245\"}&time=1517379941&token=7acc466d-1496-4969-87a0-812a1177b7b0");
//         encrypt("uid=3&key=b4c3c30bd53782599f277c34ba13835d");
//         encrypt2("123456QAZWSXEDCRFV09876543210");
//        System.out.println(encryptBySalt("111111"));
//        System.out.println(encryptBySalt("123456"));
//         encrypt(str);
//         encrypt("reqData={\"isMobile\":\"0\",\"operName\":\"test_xzqc1\",\"operPassword\":\"123456\"}&time=1509610766&token=");
//         System.out.println("zuulMD5:" + encryptZuul("reqData={\"isMobile\":\"0\",\"operName\":\"test_xzqc1\",\"operPassword\":\"123456\"}&time=1509610766&token="));
//         encrypt("uid=102&key=6eb2bcff90a1b41cdc600666241382db");
        // encrypt("uid=1&key=21698af038667a94eb22b4c1596922b5");
//        encrypt("http://www.daas-auto.com/APIS/custReqm/yongnuo/v1/product-database/lists?appId=5u8wyi8tatope5fkee3216xx7xpsl0wp&restTime=20170918103222");
//         System.out.println("明文：" + "a123456" + " 密文：" + encryptBySalt("a123456"));
         System.out.println("输入：" + "1C8D779C2117037110008715" + " 输出：" + toStringHex(str12ToAscii17("1C8D779C2117037110008715")));
//         System.out.println(formateStringToDate("", "yyyy-MM-dd HH:mm:ss"));
//        checkPattern("/business/user/login/name");
//        checkPattern("/driver/user/login/name");
//        checkPattern("/dealer/user/login/name");
//        checkPattern("/business/user/login/mobile");
//        checkPattern("/driver/user/login/mobile");
//        checkPattern("/dealer/user/login/mobile");
//        checkPattern("/user/noauth/innlogin");
//        checkPattern("/business/outBound/exportInfoByExcel");
//        checkPattern("/business/storagePlan/importTemplateDownload");
//        checkPattern("/business/warehouse/order/exportInfoByExcel");
//        checkPattern("/business/storagePlan/addInnstorageByExcel");
//        checkPattern("/business/warehouse/stock/exportInfoByExcel");
//        checkPattern("http://10.108.10.30:38060/business/outBound/exportInfoByExcel");
//        checkPattern("http://10.108.11.111:38060/business/pc/exportVehicleByExcel");
//        skipAllFilters("http://10.108.10.30:38060/business/outBound/exportInfoByExcel");
//        skipAllFilters("http://10.108.11.77:38091/dealer/index/getApi");
//        skipAllFilters("http://10.108.11.77:38091/driver/index/getApi");
//        skipAllFilters("http://10.108.11.77:38091/business/ocr/getApi");
    }

    public static void encrypt(String dataStr) {
        try {
            System.out.println("new date:" + System.currentTimeMillis());
            System.out.println("明文：" + dataStr);
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte[] s = m.digest();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                result.append(Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6));
            }
            System.out.println("密文：" + result.toString());
            // System.out.println(String.format("%04d", 1001));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void encrypt2(String dataStr) {
        try {
            System.out.println("new date:" + System.currentTimeMillis());
            System.out.println("明文：" + dataStr);
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte[] s = m.digest();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                result.append(Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6));
            }
            System.out.println("密文：" + result.toString());
            System.out.println("二次密文：" + encrypt3("AC3145CD4166BA36C421EE401D1C2AE9"));
            // System.out.println(String.format("%04d", 1001));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt3(String dataStr) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte[] s = m.digest();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                result.append(Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6));
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }    
    
    public static void md5AddSalt() {

    }

    public static String encryptBySalt(String dataStr) {
        try {
            dataStr = dataStr + MD5_SALT;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte[] s = m.digest();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                result.append(Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6));
            }
//            String realResult = encryptSalt(result.toString()); // 第二次MD5
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String encryptSalt(String dataStr) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte[] s = m.digest();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                result.append(Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6));
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static Date formateStringToDate(String stringDate, String format) {
        if ((stringDate == null) || stringDate.trim().equals("")) {
            return null;
        }
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
        try {
            return sdf.parse(stringDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void checkPattern(String str) {
//        if (Pattern.matches(".*/noauth/.*|.*/login/.*|.*storagePlan/extstorage", str)) { // 无需token校验
//        if (Pattern.matches(".*/statistics/.*|.*/exportInfoByExcel|.*/importTemplateDownload|.*/exportInfoByExcel|.*/addInnstorageByExcel|.*/exportInfoByExcel", str)) { // 无需token校验
        if (Pattern.matches(".*/statistics/.*|.*/exportInfoByExcel|.*/importTemplateDownload|.*/exportInfoByExcel"
                + "|.*/addInnstorageByExcel|.*/exportInfoByExcel|.*/sms/.*|.*/user/.*|.*/validateByUserId", str)) { // 无需token校验
            System.out.println(str + ":true");
        } else {
            System.out.println(str + ":false");
        }
    }
    
    private static void skipAllFilters(String requestUrl) {
        if (Pattern.matches(".*/statistics/.*|.*/exportInfoByExcel/.*|.*/importTemplateDownload/.*|.*/exportInfoByExcel/"
                            + ".*|.*/addInnstorageByExcel/.*|.*/exportInfoByExcel/.*|.*/sms/.*|.*/user/.*|.*/getApi", requestUrl)) {
            System.out.println(requestUrl + ":true");
        } else {
            System.out.println(requestUrl + ":false");
        }
    }
    
    public static String encryptZuul(String dataStr) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte[] s = m.digest();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                result.append(Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6));
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
    
    public static String str12ToAscii17(String str12) {
        
        String asciiStr = null;
        StringBuilder asciiBf = new StringBuilder();
        
//        String str12 = convertHexToString(str24);
        
        if (null == str12 || 24 != str12.length()) {
            return null;
        }
        
//        try {
//            byte[] str12Bytes = str12.getBytes("UTF8");
            byte[] str12Bytes = DatatypeConverter.parseHexBinary(str12);
            asciiBf.append(String.format("%02x", 0x3F & str12Bytes[0]));
            asciiBf.append(String.format("%02x", (0xFC & str12Bytes[1]) >> 2));
            asciiBf.append(String.format("%02x", ((0xF0 & str12Bytes[2]) >> 4) | ((0x03 & str12Bytes[1]) << 4)));
            asciiBf.append(String.format("%02x", ((0xC0 & str12Bytes[3]) >> 6) | ((0x0F & str12Bytes[2]) << 2)));
            asciiBf.append(String.format("%02x", 0x3F & str12Bytes[3]));
            asciiBf.append(String.format("%02x", (0xFC & str12Bytes[4]) >> 2));
            asciiBf.append(String.format("%02x", ((0xF0 & str12Bytes[5]) >> 4) | ((0x03 & str12Bytes[4]) << 4)));
            asciiBf.append(String.format("%02x", ((0xC0 & str12Bytes[6]) >> 6) | ((0x0F & str12Bytes[5]) << 2)));
            asciiBf.append(String.format("%02x", 0x3F & str12Bytes[6]));
            asciiBf.append(String.format("%02x", (0xFC & str12Bytes[7]) >> 2));
            asciiBf.append(String.format("%02x", ((0xF0 & str12Bytes[8]) >> 4) | ((0x03 & str12Bytes[7]) << 4)));
            asciiBf.append(String.format("%02x", ((0xC0 & str12Bytes[9]) >> 6) | ((0x0F & str12Bytes[8]) << 2)));
            asciiBf.append(String.format("%02x", 0x3F & str12Bytes[9]));
            asciiBf.append(String.format("%02x", (0xF0 & str12Bytes[10]) >> 4));
            asciiBf.append(String.format("%02x", 0x0F & str12Bytes[10]));
            asciiBf.append(String.format("%02x", (0xF0 & str12Bytes[11]) >> 4));
            asciiBf.append(String.format("%02x", 0x0F & str12Bytes[11]));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        
        asciiStr = asciiBf.toString();        
        return asciiStr;
    }
    
 // 转化十六进制编码为字符串
    public static String toStringHex(String s)
    {
    byte[] baKeyword = new byte[s.length()/2];
    for(int i = 0; i < baKeyword.length; i++)
    {
    try
    {
    baKeyword[i] = (byte)(0xff & Integer.parseInt(s.substring(i*2, i*2+2),16));
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    }

    try
    {
    s = new String(baKeyword, "utf-8");//UTF-16le:Not
    }
    catch (Exception e1)
    {
    e1.printStackTrace();
    }
    return s;
    }
    
    /**
     * 16进制直接转换成为字符串(无需Unicode解码)
     * @param hexStr
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }
    
    /*
     * 将16进制数字解码成字符串,适用于所有字符（包括中文）
     */
    public static String decode(String bytes, String hexString) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);
        // 将每2位16进制整数组装成一个字节
        for (int i = 0; i < bytes.length(); i += 2)
        baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString
                        .indexOf(bytes.charAt(i + 1))));
        return new String(baos.toByteArray());
    }
    
    public static String covertIntToString(int i) {
        return convertHexToString(Integer.toHexString(i));
    }
    
    public static String convertHexToString(String hex) {
        
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
 
        // 564e3a322d302e312e34 split into two characters 56, 4e, 3a...
        for (int i = 0; i < hex.length() - 1; i += 2) {
 
            // grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            // convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            // convert the decimal to character
            sb.append((char) decimal);
 
            temp.append(decimal);
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }
    
//    public static String ascii17ToStr12(String ascii17) {
//        
//        String asciiStr = null;
//        StringBuilder asciiBf = new StringBuilder();
//        
//        if (null == str12 || 12 != str12.length()) {
//            return null;
//        }
//        
//        try {
//            byte[] str12Bytes = str12.getBytes("UTF8");
//            asciiBf.append(Integer.toHexString(0x3F & str12Bytes[0]));
//            asciiBf.append(Integer.toHexString((0xFC & str12Bytes[1]) >> 2));
//            asciiBf.append(Integer.toHexString(((0xF0 & str12Bytes[2]) >> 4) | ((0x03 & str12Bytes[1]) << 4)));
//            asciiBf.append(Integer.toHexString(((0xC0 & str12Bytes[3]) >> 6) | ((0x0F & str12Bytes[2]) << 2)));
//            asciiBf.append(Integer.toHexString(0x3F & str12Bytes[3]));
//            asciiBf.append(Integer.toHexString((0xFC & str12Bytes[4]) >> 2));
//            asciiBf.append(Integer.toHexString(((0xF0 & str12Bytes[5]) >> 4) | ((0x03 & str12Bytes[4]) << 4)));
//            asciiBf.append(Integer.toHexString(((0xC0 & str12Bytes[6]) >> 6) | ((0x0F & str12Bytes[5]) << 2)));
//            asciiBf.append(Integer.toHexString(0x3F & str12Bytes[6]));
//            asciiBf.append(Integer.toHexString((0xFC & str12Bytes[7]) >> 2));
//            asciiBf.append(Integer.toHexString(((0xF0 & str12Bytes[8]) >> 4) | ((0x03 & str12Bytes[7]) << 4)));
//            asciiBf.append(Integer.toHexString(((0xC0 & str12Bytes[9]) >> 6) | ((0x0F & str12Bytes[8]) << 2)));
//            asciiBf.append(Integer.toHexString(0x3F & str12Bytes[9]));
//            asciiBf.append(Integer.toHexString((0xF0 & str12Bytes[10]) >> 4));
//            asciiBf.append(Integer.toHexString(0x0F & str12Bytes[10]));
//            asciiBf.append(Integer.toHexString((0xF0 & str12Bytes[11]) >> 4));
//            asciiBf.append(Integer.toHexString(0x0F & str12Bytes[11]));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        
//        asciiStr = asciiBf.toString();        
//        return asciiStr;
//    }
    
}
