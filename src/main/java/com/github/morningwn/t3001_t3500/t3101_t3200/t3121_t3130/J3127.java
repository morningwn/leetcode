package com.github.morningwn.t3001_t3500.t3101_t3200.t3121_t3130;

/**
 * <a href="https://leetcode.cn/problems/make-a-square-with-the-same-color">3127. 构造相同颜色的正方形</a>
 *
 * @author morningwn
 * @date 2024-08-31 15:52:24
 */
public class J3127 {

    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[i].length - 1; j++) {
                int count = 0;
                count += getC(grid[i][j]);
                count += getC(grid[i][j + 1]);
                count += getC(grid[i + 1][j]);
                count += getC(grid[i + 1][j + 1]);
                if (count <= -2 || count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getC(char c) {
        if (c == 'W') {
            return 1;
        } else {
            return -1;
        }
    }
}