package com.github.morningwn.t3001_t3500.t3101_t3200.t3121_t3130;

import com.github.morningwn.prefab.Out;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/right-triangles/description">3128. 直角三角形</a>
 *
 * @author morningwn
 * @date 2024-08-02 15:12:24
 */
public class J3128 {

    @Test
    public void test() {
        int[][] grid = null;
        grid = new int[][]{{0, 1, 0}, {0, 1, 1}, {0, 1, 0}};
        Assert.assertEquals(2, numberOfRightTriangles(grid));
        grid = new int[][]{{1, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        Assert.assertEquals(0, numberOfRightTriangles(grid));
        grid = new int[][]{{1, 0, 1}, {1, 0, 0}, {1, 0, 0}};
        Assert.assertEquals(2, numberOfRightTriangles(grid));

        grid = buildCase(1000, 1000);
//        Assert.assertEquals(2, numberOfRightTriangles(grid));

        Out.toFile("/Users/mac/IdeaProjects/leetcode/target/1.json", grid);
    }

    private int[][] buildCase(int m, int n) {
        int[][] grid = new int[m][n];
        Random random = new Random();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = random.nextInt(2);
            }
        }

        return grid;
    }

    public long numberOfRightTriangles(int[][] grid) {
        long rightTriangleCount = 0;
        int m = grid.length;
        int n = grid[0].length;
        long[] mCount = new long[m];
        long[] nCount = new long[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mCount[i] += grid[i][j];
                nCount[j] += grid[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && mCount[i] > 1 && nCount[j] > 1) {
                    rightTriangleCount += (mCount[i] - 1) * (nCount[j] - 1);
                }
            }
        }

        return rightTriangleCount;
    }
}