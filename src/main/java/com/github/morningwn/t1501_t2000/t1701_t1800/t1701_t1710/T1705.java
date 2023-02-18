package com.github.morningwn.t1501_t2000.t1701_t1800.t1701_t1710;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-number-of-eaten-apples/">1705. 吃苹果的最大数目</a>
 *
 * @author morningwn
 * @date Created in 2021/12/24 10:11
 */
public class T1705 {

    @Test
    public void test() {
        int[] apples = {3, 0, 0, 0, 0, 2};
        int[] days = {3, 0, 0, 0, 0, 2};

        Out.println(eatenApples(apples, days));
    }

    /**
     * 模拟真实情况的解法
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        return 0;
    }

    /**
     * 最小堆解法
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples1(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
        int length = apples.length;
        int count = 0;
        int index = 1;

        while (index - 1 < length || !queue.isEmpty()) {
            if (index - 1 < length) {
                queue.offer(new int[]{days[index - 1] + index - 1, apples[index - 1]});
            }

            while (!queue.isEmpty() && (queue.peek()[0] < index || queue.peek()[1] <= 0)) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                count += 1;
                queue.peek()[1] -= 1;

                if (queue.peek()[1] <= 0) {
                    queue.poll();
                }
            }

            index++;
        }

        return count;
    }
}
