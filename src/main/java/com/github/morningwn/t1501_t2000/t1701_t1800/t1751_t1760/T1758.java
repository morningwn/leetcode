package com.github.morningwn.t1501_t2000.t1701_t1800.t1751_t1760;

/**
 * <a href="https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/">1758. 生成交替二进制字符串的最少操作数</a>
 *
 * @author morningwn
 * @create in 2023/2/1 11:59
 */
public class T1758 {
    public int minOperations(String s) {
        int one = 0;
        int zero = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                if (chars[i] == '0') {
                    ++one;
                } else {
                    ++zero;
                }
            } else {
                if (chars[i] == '0') {
                    ++zero;
                } else {
                    ++one;
                }
            }
        }

        return Math.min(one, zero);
    }
}
