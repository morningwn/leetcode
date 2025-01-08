package com.github.morningwn.t2001_t2500.t2201_t2300.t2261_t2270;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/largest-3-same-digit-number-in-string">2264. 字符串中最大的 3 位相同数字</a>
 *
 * @author morningwn
 * @date 2025/01/08 10:52
 */
public class J2264 {

    @Test
    public void test() {
        Assert.assertEquals("777", largestGoodInteger("6777133339"));
        Assert.assertEquals("000", largestGoodInteger("2300019"));
        Assert.assertEquals("", largestGoodInteger("42352338"));

    }

    public String largestGoodInteger(String num) {
        Integer n = null;
        char[] charArray = num.toCharArray();
        for (int i = 2; i < charArray.length; i++) {
            if (charArray[i - 1] == charArray[i] && charArray[i - 2] == charArray[i]) {
                if (n == null || charArray[i] - '0' > n) {
                    n = charArray[i] - '0';
                }
            }
        }

        if (Objects.nonNull(n)) {
            return n + "" + n + "" + n;
        }
        return "";
    }
}