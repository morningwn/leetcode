package com.github.morningwn.t1501_t2000.t1901_t2000.t1941_t1950;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;


/**
 * <a href="https://leetcode.cn/problems/number-of-visible-people-in-a-queue/">1944. 队列中可以看到的人数</a>
 * <ul>
 * <li>{@link Difficulty#Hard}</li>
 * <li>{@link Topic#Stack}</li>
 * <li>{@link Topic#Array}</li>
 * <li>{@link Topic#MonotonicStack}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2024-01-05 16:50:29
 */
public class J1944 {

    public int[] makeTest(int length) {
        int[] heights = new int[length];
        for (int i = 0; i < length; i++) {
            heights[i] = i + 1;
        }

        Random random = new Random();
        for (int n = 0; n < 3 * length; n++) {
            int i = random.nextInt(length);
            int j = random.nextInt(length);
            int tmp = heights[i];
            heights[i] = heights[j];
            heights[j] = tmp;
        }
        return heights;
    }

    @Test
    public void test() {
        int[] heights = {10, 6, 8, 5, 11, 9};
        heights = makeTest(100000);
//        Out.println(heights);
        Out.println(canSeePersonsCount(heights));
    }

    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> deque = new LinkedList<>();
        int length = heights.length;
        int[] seeCounts = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.getFirst() <= heights[i]) {
                deque.pollFirst();
                seeCounts[i]++;
            }
            if (!deque.isEmpty()) {
                seeCounts[i]++;
            }
            deque.addFirst(heights[i]);
        }
        return seeCounts;
    }
}
