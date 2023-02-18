package com.github.morningwn.t0001_t0500.t0001_t0100.t0041_t0050;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T0043 {

    @Test
    public void test() {
        Out.println(mutiply("88", "2"));
    }

    public String mutiply(String num1, String num2) {

        //如果输入中存在0，直接返回结果
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        //分别初始化num1，num2的长度，以及结果可能的最长长度
        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 + len2;

        //初始化数组形式的结果以及字符串形式的结果
        int[] products = new int[len];
        String product = "";

        //拿num1第i个数分别乘num2
        for (int i = 0; i < len1; i++) {
            //获取num1的第i个数的整形值
//            int number1 = Integer.parseInt( num1.substring(len1-i-1, len1-i) );
            int number1 = num1.charAt(len1 - i - 1) - '0';

            //进行乘法计算
            for (int j = 0; j < len2; j++) {

                //获取num2的第j个数的整形形式
//                int number2 = Integer.parseInt( num2.substring(len2-j-1, len2-j) );
                int number2 = num2.charAt(len2 - j - 1) - '0';

                //进行数学运算
                int sum = number1 * number2 + products[j + i];
                products[j + i] = sum % 10;

                //将进位的值存储在下一位
                products[j + i + 1] += sum / 10;

//                Out.println( number1 + "\t " + number2 + "\t " + products[j+i] + "\t " + products[j+i+1]  );

            }

            //将已经计算过的较低位添加在字符串形式的结果集中
            product = products[i] + product;
        }

        //因为前len1位已经添加在结果集中了，直接从len1开始就可以了
        for (int i = len1; i < len; i++) {

            //若首位为零了
            if (products[i] == 0 && i == len - 1) {
                continue;
            }

            product = products[i] + product;
        }

        return product;

    }

}
