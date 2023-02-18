package com.github.morningwn.t0001_t0500.t0001_t0100.t0091_t0100;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/decode-ways/"></a>
 * @author morningwn
 * @create in 2023/2/7 20:54
 */
public class T0091 {

    @Test
    public void test() {
        String s = "106";
        Out.print(numDecodings(s));
    }

    public int numDecodings(String s) {
        int[] counts = new int[s.length() + 2];
        counts[0] = 0;
        counts[1] = 1;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur != '0') {
                counts[i + 2] = counts[i + 1];
            }
            if (i >= 1) {
                char pre = s.charAt(i - 1);
                if (pre != '0' && ((pre - '0') * 10 + (cur -'0')) <= 26) {
                    counts[i + 2] += counts[i];
                }
            }
        }

        return counts[s.length() + 1];
    }
}
