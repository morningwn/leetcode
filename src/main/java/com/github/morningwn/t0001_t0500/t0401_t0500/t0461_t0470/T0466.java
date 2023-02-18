package com.github.morningwn.t0001_t0500.t0401_t0500.t0461_t0470;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/count-the-repetitions/">466. 统计重复个数</a>
 *
 * @author moringwn
 * @create in 2022/5/19 16:35
 */
public class T0466 {

    @Test
    public void test() {
        String s1 = "caahumeayllfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenazkycxaa", s2 = "aac";
        int n1 = 1000000, n2 = 100;
        Out.println(getMaxRepetitions(s1, n1, s2, n2));
        Out.println(getMaxRepetitions1(s1, n1, s2, n2));
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }

        char[] s1s = s1.toCharArray();
        char[] s2s = s2.toCharArray();
        int len1 = s1s.length;
        int len2 = s2s.length;

        double size = 0.0;
        int i = 0;
        int j = 0;

        while (i < len1 * n1 && j < len2 * n2) {

            if (s1s[i % len1] == s2s[j]) {
                i++;
                j++;
            } else {
                i++;
            }

            if (j == len2) {
                j = 0;
                size++;
            }

            if (i == len1 && size > 0) {
                break;
            }
        }
        double a = (double) n1 / (double) (i);
        size = size * (len1 * a);

        return (int) (size / (double) n2);
    }

    public int getMaxRepetitions1(String s1, int n1, String s2, int n2) {
        char[] s1s = s1.toCharArray();
        char[] s2s = s2.toCharArray();
        int len1 = s1s.length;
        int len2 = s2s.length;

        int size = 0;
        int i = 0;
        int j = 0;

        while (i < len1 * n1 && j < len2 * n2) {

            if (s1s[i % len1] == s2s[j % len2]) {
                i++;
                j++;
            } else {
                i++;
            }

            if (j == len2) {
                j = 0;
                size++;
            }
        }

        return size / n2;
    }
}
