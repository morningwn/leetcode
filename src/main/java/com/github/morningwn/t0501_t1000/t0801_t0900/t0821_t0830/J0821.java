package com.github.morningwn.t0501_t1000.t0801_t0900.t0821_t0830;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/shortest-distance-to-a-character/">821. 字符的最短距离</a>
 *
 * @author moringwn
 * @create in 2022/4/18 15:44
 */
public class J0821 {

    @Test
    public void test() {
        Out.println(Arrays.toString(shortestToChar("oveleetcode", 'e')));
    }

    public int[] shortestToChar(String s, char c) {
        int length = s.length();
        int[] answers = new int[length];
        char[] chars = s.toCharArray();
        if (c != chars[0]) {
            answers[0] = length;
        }
        for (int i = 1; i < length; i++) {
            if (chars[i] == c) {
                answers[i] = 0;
            } else {
                answers[i] = answers[i - 1] + 1;
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            answers[i] = Math.min(answers[i], answers[i + 1] + 1);
        }

        return answers;
    }

    /**
     * 暴力for
     *
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar1(String s, char c) {
        int length = s.length();
        int[] answers = new int[length];
        char[] chars = s.toCharArray();

        for (int i = 0; i < length; i++) {
            int answer = length;
            for (int j = 0; j < length; j++) {
                if (c == chars[j]) {
                    answer = Math.min(answer, Math.abs(j - i));
                }
            }
            answers[i] = answer;
        }

        return answers;

    }
}
