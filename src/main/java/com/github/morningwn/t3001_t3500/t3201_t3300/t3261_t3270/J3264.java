package com.github.morningwn.t3001_t3500.t3201_t3300.t3261_t3270;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/final-array-state-after-k-multiplication-operations-i/description">3264. K 次乘运算后的最终数组 I</a>
 *
 * @author morningwn
 * @date 2024-12-13 11:15:24
 */
public class J3264 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
        }
        for(int i = 0; i < k; i++) {
            int[] minItem = queue.poll();
            nums[minItem[1]] = minItem[0] * multiplier;
            minItem[0] = minItem[0] * multiplier;
            queue.offer(minItem);
        }

        return nums;
    }

}