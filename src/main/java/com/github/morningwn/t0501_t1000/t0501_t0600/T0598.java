package com.github.morningwn.t0501_t1000.t0501_t0600;

/**
 * 598. 范围求和 II
 * <link>https://leetcode-cn.com/problems/range-addition-ii/</link>
 *
 * @author morningwn
 * @date Created in 2021/11/7 19:55
 */
public class T0598 {

    public int maxCount(int m, int n, int[][] ops) {
        int line = m;
        int row = n;

        for (int[] op : ops) {
            if (op[0] < line) {
                line = op[0];
            }
            if (op[1] < row) {
                row = op[1];
            }
        }

        return line * row;
    }
}
