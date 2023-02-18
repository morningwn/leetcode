package com.github.morningwn.interview;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/string-rotation-lcci/">面试题 01.09. 字符串轮转</a>
 *
 * @author morningwn
 * @create in 2022/9/29 11:22
 */
public class T01_09 {

    @Test
    public void test() {
        String s1 = "aa";
        String s2 = "aba";

        Out.println(isFlipedString(s1, s2));
    }

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String newStr = s1 + s1;
        char[] s1C = newStr.toCharArray();
        char[] s2C = s2.toCharArray();
        int i1 = 0;
        int i2 = 0;
        boolean flag = false;
        while (i1 < s1C.length && i2 < s2C.length) {
            if (s1C[i1] == s2C[i2]) {
                i1++;
                i2++;
                flag = true;
            } else {
                if (flag) {
                    i2 = 0;
                    flag = false;
                } else {
                    i1++;
                }
            }
        }

        return i2 == s2.length();
    }
}
