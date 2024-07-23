package com.github.morningwn.t0001_t0500.t0001_t0100.t0091_t0100;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees/">96. 不同的二叉搜索树</a>
 *
 * @author morningwn
 * @date Created in 2020/7/15 15:57
 */
public class J0096 {

    public int numTrees(int n) {
        int[] res = new int[n + 1];

        res[0] = 1;
        res[1] = 1;

        for (int i = 2; i < n + 1; ++i) {
            for (int j = 1; j <= i; ++j) {
                res[i] += res[j - 1] * res[i - j];
            }
        }

        return res[n];
    }
}
