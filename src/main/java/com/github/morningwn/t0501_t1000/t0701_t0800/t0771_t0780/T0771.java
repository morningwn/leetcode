package com.github.morningwn.t0501_t1000.t0701_t0800.t0771_t0780;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T0771 {

    @Test
    public void test() {

        Out.println(numJewelsInStones("aA", "aAAbbbb"));       //3
        Out.println(numJewelsInStones("z", "ZZ"));             //0
    }

    public int numJewelsInStones(String J, String S) {

        //最后的输出结果
        int result = 0;

        //将每一个判断项目转换为数组
        char[] item = J.toCharArray();

        //遍历字符串S输出结果
        for (int i = 0; i < S.length(); i++) {

            for (char s : item) {

                if (s == S.charAt(i)) {
                    result++;
                }
            }
        }

        return result;
    }
}
