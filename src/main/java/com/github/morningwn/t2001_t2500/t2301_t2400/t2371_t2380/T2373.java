package com.github.morningwn.t2001_t2500.t2301_t2400.t2371_t2380;

import com.github.morningwn.prefab.FormatInput;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/largest-local-values-in-a-matrix/">2373. 矩阵中的局部最大值</a>
 *
 * @author morningwn
 * @date Created in 2023/3/1 16:35
 */
public class T2373 {

    @Test
    public void test() {
        int[][] grid = FormatInput.stringTo2Array("[[2,5,5],[3,2,5],[1,2,3]]", 3);
        Out.println(grid);
        Out.println(largestLocal(grid));
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocals = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxLocals[i][j] = findMaxLocal(grid, i, j, n);
            }
        }
        return maxLocals;
    }

    private int findMaxLocal(int[][] grid, int x, int y, int n) {
        int maxLocal = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (grid[i][j] > maxLocal) {
                    maxLocal = grid[i][j];
                }
            }
        }
        return maxLocal;
    }
}
