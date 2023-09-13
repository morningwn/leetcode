package com.github.morningwn.t2501_.t2501_t2600.t2591_t2600;

/**
 * <a href="https://leetcode.cn/problems/check-knight-tour-configuration/description/">2596. 检查骑士巡视方案</a>
 *
 * @author morningwn
 * @date Created in 2023/9/13 21:46
 */
public class T2596 {

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }

        return checkValidStep(0, 0, 0, grid.length, grid);
    }

    private boolean checkValidStep(int row, int col, int step, int n, int[][] grid) {
        if (step == n * n - 1) {
            return true;
        }

        if (row - 2 > -1) {
            if (col - 1 > -1 && grid[row - 2][col - 1] == step + 1) {
                return checkValidStep(row - 2, col - 1, step + 1, n, grid);
            }
            if (col + 1 < n && grid[row - 2][col + 1] == step + 1) {
                return checkValidStep(row - 2, col + 1, step + 1, n, grid);
            }
        }

        if (row - 1 > -1) {
            if (col - 2 > -1 && grid[row - 1][col - 2] == step + 1) {
                return checkValidStep(row - 1, col - 2, step + 1, n, grid);
            }
            if (col + 2 < n && grid[row - 1][col + 2] == step + 1) {
                return checkValidStep(row - 1, col + 2, step + 1, n, grid);
            }
        }

        if (row + 1 < n) {
            if (col - 2 > -1 && grid[row + 1][col - 2] == step + 1) {
                return checkValidStep(row + 1, col - 2, step + 1, n, grid);
            }
            if (col + 2 < n && grid[row + 1][col + 2] == step + 1) {
                return checkValidStep(row + 1, col + 2, step + 1, n, grid);
            }
        }

        if (row + 2 < n) {
            if (col - 1 > -1 && grid[row + 2][col - 1] == step + 1) {
                return checkValidStep(row + 2, col - 1, step + 1, n, grid);
            }
            if (col + 1 < n && grid[row + 2][col + 1] == step + 1) {
                return checkValidStep(row + 2, col + 1, step + 1, n, grid);
            }
        }

        return false;
    }
}
