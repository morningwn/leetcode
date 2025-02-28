package com.github.morningwn.t2001_t2500.t2301_t2400.t2311_t2320;

/**
 * <a href="https://leetcode.cn/problems/check-if-matrix-is-x-matrix/">2319. 判断矩阵是否是一个 X 矩阵</a>
 *
 * @author morningwn
 * @create in 2023/1/31 0:21
 */
public class J2319 {

    public boolean checkXMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i == m -j-1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }

            }
        }

        return true;
    }
}
