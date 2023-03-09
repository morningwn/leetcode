package com.github.morningwn.t2001_t2500.t2301_t2400.t2371_t2380;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.security.PublicKey;

/**
 * <a href="https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/">2379. 得到 K 个黑块的最少涂色次数</a>
 *
 * @author morningwn
 * @date Created in 2023/3/9 21:23
 */
public class T2379 {

    @Test
    public void test() {
        String b = "BWBWBWBWBWBWBWBWBBBBWWWW";
        int k = 12;
        int minimumRecolors = minimumRecolors(b, k);
        Out.println(minimumRecolors);
    }

    public int minimumRecolors(String blocks, int k) {
        int minCount = k;
        int count = 0;
        char[] chars = blocks.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'W') {
                count++;
            }
            if (i >= k && chars[i - k] == 'W') {
                count--;
            }
            if (i >= k - 1) {
                minCount = Math.min(minCount, count);
            }
        }
        return minCount;
    }
}
