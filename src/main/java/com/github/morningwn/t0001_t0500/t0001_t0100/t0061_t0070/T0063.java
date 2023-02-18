package com.github.morningwn.t0001_t0500.t0001_t0100.t0061_t0070;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author morningwn
 * @date Created in 2020/7/6 14:14
 */
public class T0063 {

    @Test
    public void test() {
        int[][] grid = {{0}, {0}};
        Out.println(uniquePathsWithObstacles(grid));
    }

    /**
     * @author morningwn
     * @date 2020/7/6 14:40
     * @description: 动态规划，迭代法得到结果，计算每个方格能够到达的路径数量
     * @param: obstacleGrid 方格
     * @return: int 路径数
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] road = new int[m + 1][n + 1];
        road[0][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 0) {
                    road[i][j] = road[i - 1][j] + road[i][j - 1];
                }
            }
        }

        for (int[] r : road) {
            Out.println(Arrays.toString(r));
        }
        return road[m][n];
    }

    /**
     * @author morningwn
     * @date 2020/7/6 14:29
     * @description: 递归算法， 运行超时
     * @param: obstacleGrid 棋盘
     * @return: int
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        return helper(obstacleGrid, 0, 0, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }

    private int helper(int[][] grid, int i, int j, int m, int n) {
        if (i == m && j == n && grid[i][j] == 0) {
            return 1;
        }
        if (i > m || j > n) {
            return 0;
        }

        if (grid[i][j] == 1) {
            return 0;
        } else {
            return helper(grid, i + 1, j, m, n) + helper(grid, i, j + 1, m, n);
        }
    }
}
