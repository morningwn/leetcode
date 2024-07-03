package com.github.morningwn.t3001_t3500.t3101_t3200.t3101_t3110;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-operations-with-constraint/description/">3106. 满足距离约束且字典序最小的字符串</a>
 *
 * @author morningwn
 * @date 2024-07-03 18:04:24
 */
public class J3106 {

    @Test
    public void test() {
        Assert.assertEquals("aaaz", getSmallestString("zbbz", 3));
        Assert.assertEquals("aawcd", getSmallestString("xaxcd", 4));
        Assert.assertEquals("aaaaaaaaaaaaaaaaaaaaaaaaadhuyiokjhgfdsadf", getSmallestString("xaxcdgaawfwwefwesdfwwefreghuyiokjhgfdsadf", 100));

    }

    public String getSmallestString(String s, int k) {

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (k <= 0) {
                break;
            }
            char c = charArray[i];
            int fromEnd = 'z' + 1 - c;
            int fromStart = c - 'a';

            if (fromEnd <= k && fromStart >= fromEnd) {
                k -= fromEnd;
                charArray[i] = 'a';
            } else if (fromStart <= k && fromEnd >= fromEnd) {
                k -= fromStart;
                charArray[i] = 'a';
            } else {
                charArray[i] = (char) (c - k);
                k = 0;
            }

        }
        return new String(charArray);
    }
}