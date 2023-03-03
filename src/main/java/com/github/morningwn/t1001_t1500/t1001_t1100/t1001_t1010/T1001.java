package com.github.morningwn.t1001_t1500.t1001_t1100.t1001_t1010;

import org.junit.Test;

import com.github.morningwn.prefab.Out;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode-cn.com/problems/grid-illumination/">1001. 网格照明</a>
 *
 * @author morningwn
 * @date 2022-02-08 10:35:44
 */
public class T1001 {

    @Test
    public void test() {
        int n = 6;
        int[][] lamps = {{2, 5}, {4, 2}, {0, 3}, {0, 5}, {1, 4}, {4, 2}, {3, 3}, {1, 0}};
        int[][] queries = {{4, 3}, {3, 1}, {5, 3}, {0, 5}, {4, 4}, {3, 3}};

        int[] res = gridIllumination(n, lamps, queries);

        Out.println(res);
    }

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {

        // 标记灯泡的位置
        Set<Long> mark = new HashSet<>();

        // 标记被点亮的路径
        Map<Integer, Integer> lightX = new HashMap<>();
        Map<Integer, Integer> lightY = new HashMap<>();
        Map<Integer, Integer> lightLR = new HashMap<>();
        Map<Integer, Integer> lightRL = new HashMap<>();

        // 结果
        int[] res = new int[queries.length];
        // 九宮格方向
        int[][] dirs = {{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, 0}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};

        // 点亮所有的灯泡，并标记路径
        for (int[] lamp : lamps) {
            // 不重复点亮
            if (!mark.contains(makePoint(lamp[0], lamp[1]))) {
                addMap(lightX, lamp[0], 1);
                addMap(lightY, lamp[1], 1);
                addMap(lightLR, lamp[0] - lamp[1], 1);
                addMap(lightRL, lamp[0] + lamp[1], 1);

                mark.add(makePoint(lamp[0], lamp[1]));
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            if (lightX.containsKey(x) || lightY.containsKey(y) || lightLR.containsKey(x - y) || lightRL.containsKey(x + y)) {
                res[i] = 1;
            }

            // 关闭九宫格内的灯泡
            for (int[] dir : dirs) {
                if (dir[0] + x >= 0 && dir[0] + x < n && dir[1] + y >= 0 && dir[1] + y < n && mark.contains(makePoint(dir[0] + x, dir[1] + y))) {

                    if (addMap(lightX, dir[0] + x, -1) == 0) {
                        lightX.remove(dir[0] + x);
                    }
                    if (addMap(lightY, dir[1] + y, -1) == 0) {
                        lightY.remove(dir[1] + y);
                    }
                    if (addMap(lightLR, dir[0] + x - (dir[1] + y), -1) == 0) {
                        lightLR.remove(dir[0] + x - (dir[1] + y));
                    }
                    if (addMap(lightRL, dir[0] + x + dir[1] + y, -1) == 0) {
                        lightRL.remove(dir[0] + x + dir[1] + y);
                    }

                    mark.remove(makePoint(dir[0] + x, dir[1] + y));
                }
            }
        }

        return res;
    }

    private int addMap(Map<Integer, Integer> map, int key, int val) {
        int nval = map.getOrDefault(key, 0) + val;
        map.put(key, nval);
        return nval;
    }

    private Long makePoint(int x, int y) {
        return ((long) x << 32) + (long) y;
    }
}
