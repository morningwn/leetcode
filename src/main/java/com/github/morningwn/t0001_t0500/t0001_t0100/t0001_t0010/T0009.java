package com.github.morningwn.t0001_t0500.t0001_t0100.t0001_t0010;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/palindrome-number/">9. 回文数</a>
 *
 * @author morningwn
 * @date
 */
public class T0009 {

    @Test
    public void test() {
//        Out.println(new StringBuilder("123").reverse().toString());
        Out.println(isPalindrome(0));
    }

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        long num = Long.parseLong(new StringBuilder(x + "").reverse().toString());

        return num == x;
    }

    /**
     * 暴力循环，逐个判断
     */
    public boolean isPalindrome1(int x) {

        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else {
            int l = (x + "").length();

            while (l > 1) {
                if (x / (int) Math.pow(10, l - 1) != x % 10) {
                    return false;
                }
                x = x % (int) Math.pow(10, l - 1);
                x = x / 10;
                l = l - 2;
            }
            return true;
        }

    }
}
