package com.example;

import java.security.MessageDigest;
import java.util.Arrays;

public class kaoshi {
    static char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f' }; // HEX_DIGITS为16进制字符

    /*
     * 传数组 数组排序 数组拼接成字符串
     */
    public String sortLetter(String[] input) {
        Arrays.sort(input, String.CASE_INSENSITIVE_ORDER);
        System.out.println("排序后的字符串：" + Arrays.toString(input));
        StringBuilder _sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            _sb.append(input[i]);
        }
        return _sb.toString();
    }



    /*
     * md5
     */
    public final static String MD5(String s) {
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = HEX_DIGITS[byte0 >>> 4 & 0xf];
                str[k++] = HEX_DIGITS[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        kaoshi t = new kaoshi();
        StringBuilder _strb = new StringBuilder();

        _strb.append("name=").append("张三").append("&");


        _strb.append("pass=").append("123456").append("&");


        String input = _strb.toString();
//		System.out.println("得到的输入：" + input);
        String[] arr = input.split("\\,"); // 切割成数组
//		System.out.println("得到后的数组：" + Arrays.toString(arr));

        String return_string = t.sortLetter(arr);
        System.out.println("排序拼接后的字符串：" + return_string);


        String newstr = return_string;

        @SuppressWarnings("static-access")
        String return_newstr = t.MD5(newstr);
        System.out.println("md5加密后显示: " + return_newstr);

        String s=return_string+"sign="+return_newstr;
        System.out.println(s);



    }

}
