package com.github.morningwn.t2001_t2500.t2101_t2200.t2201_t2210;

import com.github.morningwn.prefab.Out;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/detonate-the-maximum-bombs/description/">2101. 引爆最多的炸弹</a>
 *
 * @author morningwn
 * @date 2024-07-22 10:14:59
 */
public class J2101 {

    @Test
    public void test() {
        int[][] bombs = null;
        int detonation = 0;
        bombs = new int[][]{{2, 1, 3}, {6, 1, 4}, {1, 2, 3}, {2, 43, 34}, {34, 56, 675}, {344, 546, 345}, {4566, 4565, 56665}, {34, 345, 656}, {6678, 5345, 76}, {7678, 35, 887}};
        detonation = maximumDetonation(bombs);
        Assert.assertEquals(10, detonation);

       bombs = buildCase(100);
       Out.println(bombs);
       detonation = maximumDetonation(bombs);

    }

    @Test
    public void testDis() {
        int[] node1 = {344, 546, 345};
        int[] node2 = {4566, 4565, 56665};
        Out.println((int) getDistance(node1, node2));
        Out.println(node2[2] * node2[2]);
    }

    private int[][] buildCase(int length) {
        Random random = new Random();
        int[][] bombs = new int[length][3];
        for (int i = 0; i < length; i++) {
            bombs[i][0] = random.nextInt(100000);
            bombs[i][1] = random.nextInt(1000);
            bombs[i][2] = random.nextInt(1000);
        }
        return bombs;
    }

    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graphs = new HashMap<>();
        for (int i = 0; i < bombs.length; i++) {
            boolean[] removed = new boolean[bombs.length];
            List<Integer> samePath = new ArrayList<>();
            samePath.add(i);
            removed[i] = true;
            findSamePath(bombs, removed, samePath);
            graphs.put(i, samePath);
        }
        int maxCount = 0;
        for (int i = 0; i < bombs.length; i++) {
            boolean[] removed = new boolean[bombs.length];
            Deque<Integer> deque = new LinkedList<>();
            deque.addLast(i);
            int count = 0;
            while (!deque.isEmpty()) {
                int first = deque.pollFirst();
                if (removed[first]) {
                    continue;
                }
                removed[first] = true;
                count++;
                List<Integer> samePath = graphs.get(first);
                deque.addAll(samePath);
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    private void findSamePath(int[][] bombs, boolean[] removed, List<Integer> samePath) {
        for (int i = 0; i < bombs.length; i++) {
            if (removed[i]) {
                continue;
            }
            for (int index : samePath) {
                if (getDistance(bombs[index], bombs[i]) > (double) bombs[index][2] * (double) bombs[index][2]) {
                    continue;
                }
                removed[i] = true;
                samePath.add(i);
                break;
            }
        }
    }

    private double getDistance(int[] node1, int[] node2) {
        return Math.pow(node1[0] - node2[0], 2) + Math.pow(node1[1] - node2[1], 2);
    }
}