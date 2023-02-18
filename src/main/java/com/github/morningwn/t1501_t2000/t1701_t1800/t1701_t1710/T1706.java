package com.github.morningwn.t1501_t2000.t1701_t1800.t1701_t1710;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/where-will-the-ball-fall/">1706. 球会落何处</a>
 *
 * @author morningwn
 * @date Created in 2022/2/24 11:33
 */
public class T1706 {

    @Test
    public void test() {
        int[][] grid = {{1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, 1, -1, -1, -1}};
        int[] res = findBall(grid);

        Out.println(Arrays.toString(res));
    }

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = decline(0, i, grid);
        }

        return res;
    }

    private int decline(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length) {
            return y;
        }

        if (y < 0 || y >= grid[x].length) {
            return -1;
        }

        if (grid[x][y] == 1) {
            if (y + 1 >= grid[x].length || grid[x][y + 1] == -1) {
                return -1;
            } else {
                return decline(x + 1, y + 1, grid);
            }
        } else {
            // -1
            if (y - 1 < 0 || grid[x][y - 1] == 1) {
                return -1;
            } else {
                return decline(x + 1, y - 1, grid);
            }
        }

    }
}
