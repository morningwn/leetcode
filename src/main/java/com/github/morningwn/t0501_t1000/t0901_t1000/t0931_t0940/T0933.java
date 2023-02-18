package com.github.morningwn.t0501_t1000.t0901_t1000.t0931_t0940;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/number-of-recent-calls/">933. 最近的请求次数</a>
 *
 * @author moringwn
 * @create in 2022/5/6 16:11
 */
public class T0933 {

    @Test
    public void test() {
        RecentCounter recentCounter = new RecentCounter();

        Out.println(recentCounter.ping(1));
        Out.println(recentCounter.ping(100));
        Out.println(recentCounter.ping(3001));
        Out.println(recentCounter.ping(3002));

    }

    class RecentCounter {
        private final int[] queue;
        private int startIndex = 0;
        private int size = 0;

        public RecentCounter() {
            queue = new int[10001];
        }

        public int ping(int t) {
            queue[size++] = t;

            int start = t - 3000;
            while (startIndex <= size && queue[startIndex] < start) {
                startIndex++;
            }
            return size - startIndex;
        }
    }
}
