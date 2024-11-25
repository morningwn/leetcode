package com.github.morningwn.t0501_t1000.t0701_t0800.t0741_t0750;

import com.github.morningwn.prefab.FormatInput;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/network-delay-time">743. 网络延迟时间</a>
 *
 * @author morningwn
 * @create in 2024/11/25 15:26
 */
public class J0743 {

    @Test
    public void test() {
//        int[][] times = buildCase(10, 60);
//        Out.println(times);
        int[][] times = null;
        times = FormatInput.stringTo2Array("[[2,1,1],[2,3,1],[3,4,1]]", 3);
        Assert.assertEquals(2, networkDelayTime(times, 4, 2));
        times = FormatInput.stringTo2Array("[[9,5,46],[3,4,58],[7,1,91],[3,8,8],[7,6,50],[9,8,27],[8,6,8],[7,8,85],[9,10,51],[4,10,42],[2,10,48],[1,8,11],[10,2,71],[10,9,61],[2,9,38],[5,2,38],[8,1,87],[10,7,26],[4,3,24],[7,10,70],[9,2,1],[2,8,78],[3,7,0],[10,4,17],[3,6,87],[2,4,45],[6,4,29],[7,3,18],[4,7,65],[3,2,87],[4,8,5],[10,3,58],[1,6,52],[8,9,99],[9,1,9],[8,7,52],[5,9,41],[4,2,95],[1,3,57],[2,3,57],[8,2,31],[4,1,27],[8,5,47],[8,3,90],[6,9,27],[10,1,8],[2,5,8],[7,4,8],[5,3,6],[1,4,79],[7,5,58],[1,10,29],[9,6,30],[6,5,37],[9,7,49],[1,2,21],[9,3,67],[10,5,85],[6,1,72],[3,9,29]]", 3);
        Assert.assertEquals(48, networkDelayTime(times, 10, 2));
        times = FormatInput.stringTo2Array("[[1,2,1],[2,1,3]]", 3);
        Assert.assertEquals(3, networkDelayTime(times, 2, 2));
    }

    private int[][] buildCase(int n, int count) {
        Set<String> map = new HashSet<>();
        int[][] times = new int[count][3];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int u = random.nextInt(n) + 1;
            int v = random.nextInt(n) + 1;
            while (map.contains(u + "-" + v) || v == u) {
                u = random.nextInt(n) + 1;
                v = random.nextInt(n) + 1;
            }
            map.add(u + "-" + v);
            times[i][0] = u;
            times[i][1] = v;
            times[i][2] = random.nextInt(101);
        }
        return times;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], -1);
            map[i][i] = 0;
        }
        for (int[] time : times) {
            map[time[0]][time[1]] = time[2];
        }
        boolean[] visited = new boolean[n + 1];
        Integer choosedIndex = chooseIndex(map, visited, k, n);
        while (choosedIndex != null) {
            visited[choosedIndex] = true;
            refersh(map, choosedIndex, k, n);
            choosedIndex = chooseIndex(map, visited, k, n);
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (k != i && map[k][i] == -1) {
                return -1;
            }
            res = Math.max(res, map[k][i]);
        }
        return res;
    }

    private void refersh(int[][] map, int cur, int start, int n) {
        for (int i = 1; i <= n; i++) {
            if (map[cur][i] != -1) {
                int tims = map[start][cur] + map[cur][i];
                if (map[start][i] == -1 || map[start][i] > tims) {
                    map[start][i] = tims;
                }
            }
        }
    }

    private Integer chooseIndex(int[][] map, boolean[] visited, int start, int n) {
        Integer choosedIndex = null;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && map[start][i] != -1) {
                if (choosedIndex == null || map[start][choosedIndex] >= map[start][i]) {
                    choosedIndex = i;
                }
            }
        }
        return choosedIndex;
    }
}