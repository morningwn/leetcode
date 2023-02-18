package com.github.morningwn.t1001_t1500.t1001_t1100.t1031_t1040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/coloring-a-border/">1034. 边界着色</a>
 *
 * @author morningwn
 * @date Created in 2021/12/7 15:58
 */
public class T1034 {

    private int l;
    private int r;
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    @Test
    public void test() {
        int[][] grid = {{1, 1}, {1, 2}};
        int row = 0;
        int col = 0;
        int color = 3;

        int[][] res = colorBorder(grid, row, col, color);

        for (int[] re : res) {
            Out.println(Arrays.toString(re));
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        l = grid.length;
        r = grid[0].length;

        int[][] res = new int[l][r];

        helper(grid, row, col, grid[row][col], color, res);

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < r; j++) {
                if (res[i][j] == 0) {
                    res[i][j] = grid[i][j];
                }
            }
        }

        return res;
    }

    private void helper(int[][] grid, int x, int y, int target, int color, int[][] res) {

        if (x >= l || y >= r || x < 0 || y < 0 || res[x][y] != 0) {
            return;
        }

        if (grid[x][y] != target) {
            res[x][y] = grid[x][y];
            return;
        }

        if (judge(grid, x, y, target)) {
            res[x][y] = color;
        } else {
            res[x][y] = grid[x][y];
        }

        for (int[] dir : dirs) {
            helper(grid, x + dir[0], y + dir[1], target, color, res);
        }

    }


    /**
     * 判断是否为边界
     *
     * @param grid
     * @param x
     * @param y
     * @param target
     * @return 是true，否false
     */
    private boolean judge(int[][] grid, int x, int y, int target) {
        int count = 0;

        if (x + 1 < l && grid[x + 1][y] == target) {
            count++;
        }
        if (x - 1 >= 0 && grid[x - 1][y] == target) {
            count++;
        }

        if (y + 1 < r && grid[x][y + 1] == target) {
            count++;
        }
        if (y - 1 >= 0 && grid[x][y - 1] == target) {
            count++;
        }

        return count != 4;
    }
}
