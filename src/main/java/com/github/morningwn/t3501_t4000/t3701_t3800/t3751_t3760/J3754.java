package com.github.morningwn.t3501_t4000.t3701_t3800.t3751_t3760;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * <a href="https://leetcode.cn/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/">3754. 连接非零数字并乘以其数字和 I</a>
 */
public class J3754 {

    @Test
    public void test() {
        Assert.assertEquals(12340, sumAndMultiply(10203004));
        Assert.assertEquals(1, sumAndMultiply(1000));

    }

    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        long index = 1;

        while (n > 0) {
            int num = n % 10;
            sum += num;
            if (num != 0) {
                x += num * index;
                index *= 10;
            }
            n /= 10;
        }
        return sum * x;
    }
}
