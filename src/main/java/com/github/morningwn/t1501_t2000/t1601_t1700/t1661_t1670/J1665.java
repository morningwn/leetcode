package com.github.morningwn.t1501_t2000.t1601_t1700.t1661_t1670;

import com.github.morningwn.prefab.FormatInput;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/minimum-initial-energy-to-finish-tasks/?envType=daily-question&envId=2026-06-02">1665. 完成所有任务的最少初始能量</a>
 * @author morningwn
 * @create in 2026/6/2 11:02
 */
public class J1665 {

    @Test
    public void test1() {
        int[][] tasks = FormatInput.stringTo2Array("[[1,3],[2,4],[10,11],[10,12],[8,9]]", 2);
        int i = minimumEffort(tasks);
        Assert.assertEquals(32, i);
    }

    public int[][] buildTest(int n, int max) {
        Random random = new Random();
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            tasks[i][0] = random.nextInt(max) + 1;
            tasks[i][1] = tasks[i][0] + random.nextInt(max);
        }

        return tasks;
    }

    public int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, Comparator.comparingInt((int[] o) -> o[1] - o[0]).thenComparingInt(o -> o[1]));

        int totalCost = 0;
        for (int[] task : tasks) {
            totalCost += task[0];
            if (totalCost < task[1]) {
                totalCost = task[1];
            }
        }
        return totalCost;
    }
}
