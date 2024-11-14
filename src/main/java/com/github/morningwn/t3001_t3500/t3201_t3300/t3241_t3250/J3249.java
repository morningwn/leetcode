package com.github.morningwn.t3001_t3500.t3201_t3300.t3241_t3250;

import com.github.morningwn.prefab.FormatInput;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/count-the-number-of-good-nodes">3249. 统计好节点的数目</a>
 *
 * @author morningwn
 * @date 2024-11-14 14:29:24
 */
public class J3249 {

    @Test
    public void test() {
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        Assert.assertEquals(7, countGoodNodes(edges));
        edges = FormatInput.stringTo2Array("[[6,0],[1,0],[5,1],[2,5],[3,1],[4,3]]", 2);
        Assert.assertEquals(6, countGoodNodes(edges));
    }

    int totalCount = 0;

    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());

        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        totalCount = 0;
        dfs(g, 0, -1);
        return totalCount;
    }

    private int dfs(List<Integer>[] g, int curNode, int parent) {
        int count = -1;
        boolean add = true;
        int totalNodeCount = 1;
        List<Integer> list = g[curNode];
        for (Integer node : list) {
            if (node == parent) {
                continue;
            }
            int tmp = dfs(g, node, curNode);
            if (count != -1 && tmp != count) {
                add = false;
            }
            count = tmp;
            totalNodeCount += tmp;
        }
        if (add) {
            totalCount++;
        }
        return totalNodeCount;
    }
}