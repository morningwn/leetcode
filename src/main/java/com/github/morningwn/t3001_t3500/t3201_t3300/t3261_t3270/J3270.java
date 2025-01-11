package com.github.morningwn.t3001_t3500.t3201_t3300.t3261_t3270;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/find-the-key-of-the-numbers">3270. 求出数字答案</a>
 *
 * @author morningwn
 * @date 2025-01-11 15:25:24
 */
public class J3270 {

    @Test
    public void test() {
        Assert.assertEquals(7772, generateKey(9872, 8792, 7989));
    }


    public int generateKey(int num1, int num2, int num3) {
        int key = 0;

        for (int i = 10000; i > 0; i /= 10) {
            int max = Math.min(num1 / i, Math.min(num2 / i, num3 / i));
            key += max * i;
            num1 %= i;
            num2 %= i;
            num3 %= i;

        }
        return key;
    }
}