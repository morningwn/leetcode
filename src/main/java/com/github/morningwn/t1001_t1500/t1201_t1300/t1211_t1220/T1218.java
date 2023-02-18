package com.github.morningwn.t1001_t1500.t1201_t1300.t1211_t1220;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference">1218. 最长定差子序列</a>
 *
 * @author moringwn
 * @date 2021/11/4 下午2:49
 */
public class T1218 {

    @Test
    public void test() {
        int[] arr = {3, 0, -3, 4, -4, 7, 6};
        int difference = 3;

        Out.println(longestSubsequence(arr, difference));
    }

    public int longestSubsequence(int[] arr, int difference) {
        int[] counts = new int[40001];
        int res = 0;

        for (int i : arr) {
            counts[i + 20000] = counts[i + 20000 - difference] + 1;
            res = Math.max(res, counts[i + 20000]);
        }

        return res;
    }
}
