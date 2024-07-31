package com.github.morningwn.t3001_t3500.t3101_t3200.t3111_t3120;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/minimum-rectangles-to-cover-points/">3111. 覆盖所有点的最少矩形数目</a>
 *
 * @author morningwn
 * @date 2024-07-18 17:48:24
 */
public class J3111 {

    @Test
    public void test() {
        int[][] points = null;
        points = new int[][]{{2, 1}, {1, 0}, {1, 4}, {1, 8}, {3, 5}, {4, 6}};
        Assert.assertEquals(2, minRectanglesToCoverPoints(points, 1));
    }

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, Comparator.comparingInt(point -> point[0]));
        int rectangleCount = 1;
        int rX = points[0][0];
        for (int i = 0; i < points.length; i++) {
            if (rX + w < points[i][0]) {
                rX = points[i][0];
                rectangleCount++;
            }
        }
        return rectangleCount;
    }
}