package com.github.morningwn.t0501_t1000.t0801_t0900.t0891_t0900;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/surface-area-of-3d-shapes/">892. 三维形体的表面积</a>
 *
 * @author morningwn
 * @date
 */
public class T0892 {

    @Test
    public void test() {
//        int[][] grid = {{2}};           //10
//        int[][] grid = {{1,2},{3,4}};           //34
//        int[][] grid = {{1,0},{0,2}};           //16
//        int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};           //32
        int[][] grid = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};           //46

        Out.println(surfaceArea(grid));
    }

    public int surfaceArea(int[][] grid) {

        int n = grid.length;        //输入数组长度
        int area = 0;               //总面积

        //遍历整个数组，依次累加每个位置的面积
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int tmp = 0;        //当前位置的面积

                //求出表面积（未减去遮挡部分）
                if (grid[i][j] > 0) {
                    tmp = (4 * grid[i][j]) + 2;
                } else {
                    continue;
                }

                //减去遮挡部分的面积
                if (i - 1 >= 0) {
                    tmp -= Math.min(grid[i][j], grid[i - 1][j]);
                }

                if (i + 1 < n) {
                    tmp -= Math.min(grid[i][j], grid[i + 1][j]);
                }

                if (j - 1 >= 0) {
                    tmp -= Math.min(grid[i][j], grid[i][j - 1]);
                }

                if (j + 1 < n) {
                    tmp -= Math.min(grid[i][j], grid[i][j + 1]);
                }

                area += tmp;
            }
        }

        return area;
    }

}
