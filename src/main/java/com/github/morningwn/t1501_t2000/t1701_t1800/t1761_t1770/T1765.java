package com.github.morningwn.t1501_t2000.t1701_t1800.t1761_t1770;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/map-of-highest-peak/">1765.地图中的最高点</a>
 *
 * @author morningwn
 * @date 2022-01-29 10:22:28
 */
public class T1765 {

    @Test
    public void test() {
        int[][] isWater = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}};

        int[][] hight = highestPeak(isWater);

        for (int[] is : hight) {
            Out.println(Arrays.toString(is));
        }
    }

    public int[][] highestPeak(int[][] isWater) {

        int rowLen = isWater.length;
        int colLen = isWater[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] hight = new int[rowLen][colLen];
        boolean[][] navigation = new boolean[rowLen][colLen];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    navigation[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] dir : dirs) {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];

                if (x >= 0 && x < rowLen && y >= 0 && y < colLen && !navigation[x][y]) {
                    hight[x][y] = hight[node[0]][node[1]] + 1;
                    navigation[x][y] = true;
                    queue.offer(new int[]{x, y});
                }

            }

        }

        return hight;
    }

}
