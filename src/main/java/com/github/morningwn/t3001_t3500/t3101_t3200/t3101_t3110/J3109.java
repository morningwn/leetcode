package com.github.morningwn.t3001_t3500.t3101_t3200.t3101_t3110;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/number-of-changing-keys"></a>
 *
 * @author morningwn
 * @date 2025-01-07 15:49:24
 */
public class J3109 {

    @Test
    public void test() {
        Assert.assertEquals(2, countKeyChanges("aAbBcC"));
        Assert.assertEquals(0, countKeyChanges("AaAaAaaA"));
        Assert.assertEquals(61, countKeyChanges("aAbBcCwefwesdWEWWWWwwWWeefrwerWEEwweewWEEWFWEwwEweweghutyiyuerfgaeqwfWFWGFEGHER"));
    }

    public int countKeyChanges(String s) {
        char[] charArray = s.toCharArray();
        int def = 'A' - 'a';
        int count = 0;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] != charArray[i - 1]
                    && charArray[i] != charArray[i - 1] + def
                    && charArray[i] + def != charArray[i - 1]) {
                count++;
            }
        }

        return count;
    }
}