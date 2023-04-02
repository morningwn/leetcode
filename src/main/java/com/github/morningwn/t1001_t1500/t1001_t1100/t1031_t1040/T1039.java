package com.github.morningwn.t1001_t1500.t1001_t1100.t1031_t1040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/">1039. 多边形三角剖分的最低得分</a>
 *
 * @author morningwn
 * @create in 2023/4/2 16:04
 */
public class T1039 {

    @Test
    public void test() {
        int[] values = {1, 2, 3, 4, 4, 3, 2, 1};
        int minScore = minScoreTriangulation(values);
        Out.print(minScore);
    }

    public int minScoreTriangulation(int[] values) {
        return dp(0, values.length - 1, values, new HashMap<>());
    }

    private int dp(int start, int end, int[] values, Map<Integer, Integer> map) {
        if (start + 2 > end) {
            return 0;
        }
        if (start + 2 == end) {
            return values[start] * values[start + 1] * values[end];
        }

        int key = start * 1000 + end;
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            int minScore = Integer.MAX_VALUE;
            for (int i = start + 2; i < end; i++) {
                minScore = Math.min(minScore, values[start] * values[i] * values[end] + dp(start, i, values, map) + dp(i, end, values, map));
            }
            map.put(key, minScore);
            return minScore;
        }
    }

}
