package com.github.morningwn.t0001_t0500.t0301_t0400.t0341_t0350;

/**
 * 反转字符串
 *
 * @author morningwn
 * @date 2020/10/8  19:45
 */
public class T0344 {

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;

        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }
}
