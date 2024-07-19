package com.github.morningwn.t3001_t3500.t3101_t3200.t3111_t3120;

import com.github.morningwn.prefab.Out;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/minimum-time-to-visit-disappearing-nodes/description/">3112. 访问消失节点的最少时间</a>
 *
 * @author morningwn
 * @date 2024-07-18 17:48:24
 */
public class J3112 {

    @Test
    public void test() {
        int n = 3;
        int[][] edges = null;
        int[] disappear = null;
        int[] minimumTime = null;


        n = 3;
        edges = new int[][]{{0, 1, 2}, {1, 2, 1}, {0, 2, 4}};
        disappear = new int[]{1, 1, 5};
        minimumTime = minimumTime(n, edges, disappear);
        Out.println(minimumTime);
        Assert.assertArrayEquals(new int[]{0, -1, 4}, minimumTime);

        n = 2;
        edges = new int[][]{{0, 1, 1}};
        disappear = new int[]{1, 1};
        minimumTime = minimumTime(n, edges, disappear);
        Out.println(minimumTime);
        Assert.assertArrayEquals(new int[]{0, -1}, minimumTime);


        n = 3;
        edges = new int[][]{{0, 1, 2}, {1, 2, 1}, {0, 2, 4}};
        disappear = new int[]{1, 3, 5};
        minimumTime = minimumTime(n, edges, disappear);
        Out.println(minimumTime);
        Assert.assertArrayEquals(new int[]{0, 2, 3}, minimumTime);
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int[] minTimes = new int[n];
        boolean[] visited = new boolean[n];

        List<int[]>[] graph = new ArrayList[n];

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        queue.add(new int[]{0, 0});

        Arrays.fill(minTimes, -1);

        for (int[] edge : edges) {
            if (graph[edge[0]] == null) {
                graph[edge[0]] = new ArrayList<>();
            }
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            if (graph[edge[1]] == null) {
                graph[edge[1]] = new ArrayList<>();
            }
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        while (!queue.isEmpty()) {
            int[] minNode = queue.poll();
            if (visited[minNode[0]]) {
                continue;
            }
            visited[minNode[0]] = true;
            minTimes[minNode[0]] = minNode[1];
            List<int[]> list = graph[minNode[0]];

            if (list == null) {
                continue;
            }

            for (int[] next : list) {
                if (visited[next[0]]) {
                    continue;
                }
                Integer cost = next[1] + minNode[1];
                if (cost < disappear[next[0]]) {
                    queue.offer(new int[]{next[0], cost});
                }
            }
        }
        return minTimes;
    }

}