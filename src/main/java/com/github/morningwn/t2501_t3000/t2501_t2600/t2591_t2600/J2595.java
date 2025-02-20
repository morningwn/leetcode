package com.github.morningwn.t2501_t3000.t2501_t2600.t2591_t2600;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/number-of-even-and-odd-bits">2595. 奇偶位数</a>
 *
 * @author morningwn
 * @date Created in 2025/2/20 20:46
 */
public class J2595 {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 2}, evenOddBit(50));
        Assert.assertArrayEquals(new int[]{0, 1}, evenOddBit(2));
        Assert.assertArrayEquals(new int[]{2, 4}, evenOddBit(1000));
    }

    public int[] evenOddBit(int n) {
        int even = 0;
        int odd = 0;
        int index = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (index % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            index++;
            n = n / 2;
        }

        return new int[]{even, odd};
    }
}