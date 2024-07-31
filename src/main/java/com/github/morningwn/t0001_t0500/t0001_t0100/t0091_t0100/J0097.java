package com.github.morningwn.t0001_t0500.t0001_t0100.t0091_t0100;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/interleaving-string/description/">97. 交错字符串</a>
 *
 * @author morningwn
 * @date 2024-07-18 15:59:24
 */
public class J0097 {

    @Test
    public void test() {
        Assert.assertEquals(true, isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        Assert.assertEquals(true, isInterleave("", "", ""));
        Assert.assertEquals(false, isInterleave("asd", "basd", "abgwe"));
        Assert.assertEquals(false, isInterleave("abababababababababababababababababababababababababababababababababababababababababababababababababbb",
            "babababababababababababababababababababababababababababababababababababababababababababababababaaaba",
            "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 + l2 != s3.length()) {
            return false;
        }
        boolean[][] f = new boolean[l1 + 1][l2 + 1];
        f[0][0] = true;

        for (int i = 0; i <= l1; ++i) {
            for (int j = 0; j <= l2; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p);
                }
            }
        }
        return f[l1][l2];
    }

}