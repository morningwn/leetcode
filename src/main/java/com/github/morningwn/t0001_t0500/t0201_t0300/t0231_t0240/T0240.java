package com.github.morningwn.t0001_t0500.t0201_t0300.t0231_t0240;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 240. 搜索二维矩阵 II
 * <link>https://leetcode-cn.com/problems/search-a-2d-matrix-ii/</link>
 *
 * @author moringwn
 * @date 2021/10/25 上午11:54
 */
public class T0240 {

    @Test
    public void test() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        Out.println(searchMatrix(matrix, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }
}
