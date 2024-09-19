package com.github.morningwn.t2001_t2500.t2401_t2500.t2411_t2420;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/length-of-the-longest-alphabetical-continuous-substring/">2414. 最长的字母序连续子字符串的长度</a>
 *
 * @author morningwn
 * @date 2024-09-19 16:32:59
 */
public class J2414 {

    @Test
    public void test() {
        Assert.assertEquals(2, longestContinuousSubstring("abacaba"));
        Assert.assertEquals(5, longestContinuousSubstring("abcde"));
        Assert.assertEquals(26, longestContinuousSubstring("abcdefghijklmnopqrstuvwxyz"));
    }

    public int longestContinuousSubstring(String s) {
        int maxLength = 0;
        char pfDigit = '0';
        int curLength = 0;
        for (char c : s.toCharArray()) {
            if (c == pfDigit + 1) {
                curLength++;
            } else {
                maxLength = Math.max(maxLength, curLength);
                if (maxLength == 26) {
                    return maxLength;
                }
                curLength = 1;
            }
            pfDigit = c;
        }
        return Math.max(maxLength, curLength);
    }
}