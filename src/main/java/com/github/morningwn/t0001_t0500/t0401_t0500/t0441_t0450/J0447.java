package com.github.morningwn.t0001_t0500.t0401_t0500.t0441_t0450;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * <a href="https://leetcode.cn/problems/number-of-boomerangs/">447. 回旋镖的数量</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#Array}</li>
 * <li>{@link Topic#HashTable}</li>
 * <li>{@link Topic#Math}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2021/9/13 上午11:27
 */
public class J0447 {

    @Test
    public void test() {
//        // 2
//        int[][] points = {{0,0},{1,0},{2,0}};

//        // 2
//        int[][] points = {{1, 1}, {2, 2}, {3, 3}};

//        //4
//        int[][] points = {{1, 1}, {2, 2}, {3, 3}, {4, 4}};

        // 20
        int[][] points = {{0, 0}, {1, 0}, {2, 0}, {1, 1}, {2, 2}, {3, 3}, {3, 2}};

//        //8
//        int[][] points = {{1,1}, {3,1}, {2,3}, {4,3}, {5,1}};

//        // 8
//        int[][] points = {{1, 1}, {2, 2}, {0, 0}, {2,0}};

        Out.println(numberOfBoomerangs(points));
    }


    public int numberOfBoomerangs(int[][] points) {

        int length = points.length;
        int res = 0;

        for (int[] point : points) {

            Map<Integer, Integer> distanceMap = new HashMap<>(length);

            for (int[] ints : points) {

                // 计算两点之间的距离
                int distance = getDistance(point, ints);

                // 统计当前点到达其他几个点的距离
                int count = distanceMap.getOrDefault(distance, 0) + 1;
                distanceMap.put(distance, count);
            }

            // 计算组合数
            for (Map.Entry<Integer, Integer> entry : distanceMap.entrySet()) {
                res += getCombination(entry.getValue());
            }
        }

        return res;
    }

    /**
     * 返回两点之间的距离
     *
     * @param x 点x
     * @param y 点y
     * @return
     */
    private int getDistance(int[] x, int[] y) {
        return (int) (Math.pow(x[0] - y[0], 2) + Math.pow(x[1] - y[1], 2));
    }

    /**
     * 计算组合结果
     *
     * @param c
     * @return
     */
    private int getCombination(int c) {
        if (c >= 1) {
            return c * (c - 1);
        } else {
            return 0;
        }
    }
}
