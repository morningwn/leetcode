package com.github.morningwn.t0501_t1000.t0601_t0700.t0641_t0650;

import cn.hutool.core.util.NumberUtil;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/palindromic-substrings/">647. 回文子串</a>
 *
 * @author morningwn
 * @create in  2020-08-19 18:15
 */
public class T0647 {

    @Test
    public void test() {
        String s = "abc";
        Out.println(countSubstrings(s));
        Out.println(NumberUtil.isDouble("1."));
        Out.println(Double.parseDouble("1."));
    }

    public int countSubstrings(String s) {
        char[] cs = s.toCharArray();
        int[] counts = new int[cs.length + 1];

        for (int i = 1; i < counts.length; i++) {

            int count = 1;
            for (int j = i - 2; j >= 0; j--) {
                if (cs[i - 1] == cs[j]) {
                    count++;
                } else {
                    break;
                }
            }
            counts[i] = counts[i - 1] + count;
        }

        return counts[cs.length];
    }
}
