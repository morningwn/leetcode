package com.github.morningwn.t3001_t3500.t3101_t3200.t3141_t3150;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/check-if-grid-satisfies-conditions">3142. 判断矩阵是否满足条件</a>
 *
 * @author morningwn
 * @date 2024-08-29 18:33:24
 */
public class J3142 {

    @Test
    public void test() {
        Assert.assertEquals(true, satisfiesConditions(new int[][]{{1}}));
        Assert.assertEquals(true, satisfiesConditions(new int[][]{{1, 0, 2}, {1, 0, 2}}));
        Assert.assertEquals(false, satisfiesConditions(new int[][]{{1, 1, 1}, {0, 0, 0}}));
    }

    public boolean satisfiesConditions(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i + 1 < grid.length && grid[i + 1][j] != grid[i][j]) {
                    return false;
                }

                if (j + 1 < grid[i].length && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}