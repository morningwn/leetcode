package com.github.morningwn.t0501_t1000.t0901_t1000.t0941_t0950;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/di-string-match/">942. 增减字符串匹配</a>
 *
 * @author moringwn
 * @create in 2022/5/9 17:53
 */
public class T0942 {

    @Test
    public void test() {
        String s = "DDI";

        Out.println(Arrays.toString(diStringMatch(s)));
    }

    public int[] diStringMatch(String s) {
        int max = s.length();
        int min = 0;
        int[] result = new int[s.length() + 1];
        if (s.charAt(0) == 'I') {
            result[0] = min++;
        } else {
            result[0] = max--;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                result[i] = min++;
            } else {
                result[i] = max--;
            }
        }

        result[s.length()] = max;
        return result;
    }
}
