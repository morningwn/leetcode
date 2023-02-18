package com.github.morningwn.t1001_t1500.t1201_t1300.t1261_t1270;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/minimum-time-visiting-all-points/">1266. 访问所有点的最小时间</a>
 *
 * @author moringwn
 * @date
 */
public class T1266 {

    @Test
    public void test() {

        Out.println(minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));       //7
        Out.println(minTimeToVisitAllPoints(new int[][]{{3, 2}, {-2, 2}}));              //5

    }

    public int minTimeToVisitAllPoints(int[][] points) {

        int resut = 0;

        for (int i = 0; i < points.length - 1; i++) {

            int x = Math.abs(points[i][0] - points[i + 1][0]);
            int y = Math.abs(points[i][1] - points[i + 1][1]);

            resut += x > y ? x : y;
        }
        return resut;
    }
}
