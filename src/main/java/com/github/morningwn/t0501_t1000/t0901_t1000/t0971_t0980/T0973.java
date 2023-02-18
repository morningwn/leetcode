package com.github.morningwn.t0501_t1000.t0901_t1000.t0971_t0980;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author morningwn
 * @date 2020/11/9 8:56
 */
public class T0973 {

    public int[][] kClosest(int[][] points, int K) {
        Map<int[], Integer> sqrts = new HashMap<>();

        for (int[] point : points) {
            sqrts.put(point, (int) Math.pow(point[0], 2) + (int) Math.pow(point[1], 2));
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                return Integer.compare(sqrts.get(point1), sqrts.get(point2));
            }
        });

        int[][] res = Arrays.copyOf(points, K);
        return res;
    }
}
