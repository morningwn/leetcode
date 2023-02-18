package com.github.morningwn.t0501_t1000.t0801_t0900.t0801_t0810;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/">807. 保持城市天际线</a>
 *
 * @author morningwn
 * @date Created in 2020/12/7 0:00
 */
public class T0807 {

    @Test
    public void test() {
        //第一个测试用例，输出结果为35
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        Out.println(maxIncreaseKeepingSkyline(grid));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {

        //用来存储水平和竖直方向的天际线
        int[] l = new int[grid[0].length];
        int[] r = new int[grid.length];
        //扩展后的总高度,原本总高度
        int result = 0, altitude = 0;

        //获取每个方向的天际线，同行（列）最大值
        //获取总高度
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                l[i] = Math.max(l[i], grid[i][j]);
                r[j] = Math.max(r[j], grid[i][j]);

                altitude += grid[i][j];
            }
        }

        //获取扩展后的总高度，该行列对应天际线的最小值
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result += Math.min(l[i], r[j]);
            }
        }

        return result - altitude;
    }
}
