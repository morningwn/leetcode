package com.github.morningwn.t1001_t1500.t1101_t1200.t1131_t1140;

/**
 * <a href="https://leetcode.cn/problems/n-th-tribonacci-number/">1137. 第 N 个泰波那契数</a>
 *
 * @author morningwn
 * @date
 */
public class T1137 {

    public int tribonacci(int n) {

        int t0 = 0, t1 = 1, t2 = 1;

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }

        int output = 0;

        for (int i = 0; i < n - 2; i++) {
            output = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = output;
        }
        return output;

    }
}
