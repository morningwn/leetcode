package com.github.morningwn.t0001_t0500.t0001_t0100.t0061_t0070;

import com.github.morningwn.prefab.Out;

import java.util.Arrays;

/**
 * @author morningwn
 * @date Created in 2020/7/23 22:00
 */
public class T0064 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }

        int column = grid[0].length;
        if (column == 0) {
            return 0;
        }

        int[] counts = new int[column + 1];

        for (int i = 1; i <= column; i++) {
            counts[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                counts[j] = Math.min(counts[j - 1], counts[j]) + grid[i - 1][j - 1];
            }
            Out.println(Arrays.toString(counts));
        }

        return counts[column];
    }

    /**
     * @author morningwn
     * @date 2020/7/23 22:17
     * @description: 动态规划
     * @param: grid
     * @return: int
     */
    public int minPathSum1(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }

        int column = grid[0].length;
        if (column == 0) {
            return 0;
        }

        int[][] counts = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            counts[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= column; i++) {
            counts[0][i] = Integer.MAX_VALUE;
        }
        counts[0][1] = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                counts[i][j] = Math.min(counts[i][j - 1], counts[i - 1][j]) + grid[i - 1][j - 1];
            }
        }

        for (int[] count : counts) {
            Out.println(Arrays.toString(count));
        }
        return counts[row][column];
    }
}
