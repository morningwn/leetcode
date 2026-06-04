package com.github.morningwn.t3501_t4000.t3701_t3800.t3751_t3760;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/total-waviness-of-numbers-in-range-i">3751. 范围内总波动值 I</a>
 *
 * @author morningwn
 * @date 2026-06-04 14:16
 */
public class J3751 {

    @Test
    public void test() {
        Assert.assertEquals(3, totalWaviness(120, 130));
        Assert.assertEquals(2, totalWaviness(4848, 4848));
        Assert.assertEquals(166005, totalWaviness(1, 100000));
    }

    public int totalWaviness(int num1, int num2) {
        int waviness = 0;
        for (int i = Math.max(num1, 101); i <= num2; i++) {
            waviness += getWaviness(i);
        }

        return waviness;
    }

    private int getWaviness(int num) {
        int waviness = 0;
        int last0 = num % 10;
        num /= 10;
        int last1 = num % 10;
        num /= 10;
        int last2 = num % 10;

        do {
            num /= 10;
            if (last0 > last1 && last1 < last2) {
                waviness++;
            } else if (last0 < last1 && last1 > last2) {
                waviness++;
            }
            last0 = last1;
            last1 = last2;
            last2 = num % 10;
        } while (num > 0);

        return waviness;
    }
}
