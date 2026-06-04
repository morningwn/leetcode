package com.github.morningwn.t2501_t3000.t2501_t2600.t2571_t2580;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/count-ways-to-group-overlapping-ranges/">2580. 统计将重叠区间合并成组的方案数</a>
 *
 * @author morningwn
 * @date Created in 2023/3/4 23:09
 */
public class J2580 {

    @Test
    public void test() {
        int[][] ranges = {{0, 2}};
        Out.println(countWays(ranges));
    }

    public int countWays(int[][] ranges) {
        List<int[]> ways = new ArrayList<>(ranges.length);
        ways.addAll(Arrays.asList(ranges));
        ways.sort((w1, w2) -> {
            if (w1[0] == w2[0]) {
                return Integer.compare(w1[1], w2[1]);
            } else {
                return Integer.compare(w1[0], w2[0]);
            }
        });

        int group = 0;
        int end = -1;
        for (int[] way : ways) {
            if (way[0] > end) {
                group++;
                end = way[1];
            } else {
                end = Math.max(end, way[1]);
            }
        }
        int count = 1;
        final int MOD = 1000000007;
        for (int i = 0; i < group; i++) {
            count = count * 2 % MOD;
        }
        return count;
    }
}
