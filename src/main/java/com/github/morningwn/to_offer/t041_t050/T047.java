package com.github.morningwn.to_offer.t041_t050;

/**
 * <a href="https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/">剑指 Offer 47. 礼物的最大价值</a>
 *
 * @author morningwn
 * @date Created in 2023/3/8 21:02
 */
public class T047 {

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] valueCount = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valueCount[i + 1][j + 1] = Math.max(valueCount[i][j + 1], valueCount[i + 1][j]) + grid[i][j];
            }
        }
        return valueCount[m][n];
    }
}
