package com.github.morningwn.t1501_t2000.t1701_t1800.t1791_t1800;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/maximum-average-pass-ratio/">1792. 最大平均通过率</a>
 *
 * @author morningwn
 * @date Created in 2023/2/19 23:14
 */
public class T1792 {

    @Test
    public void test() {
        double ratio = (4 / 6.0 + 3 / 9.0 + 5 / 6.0 + 3 / 11.0) / 4.0;

        Out.println(ratio);

        int[][] classes = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        int extraStudents = 4;

        Out.println(maxAverageRatio(classes, extraStudents));
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> classQueue = new PriorityQueue<>(Comparator.comparingDouble(a -> (double) a[0] / a[1] - (a[0] + 1.0) / (a[1] + 1.0)));
        for (int[] aClass : classes) {
            classQueue.offer(aClass);
        }
        while (extraStudents > 0) {
            int[] peek = classQueue.poll();
            peek[0] = peek[0] + 1;
            peek[1] = peek[1] + 1;
            extraStudents--;
            classQueue.offer(peek);
        }

        double res = 0.0;
        for (int[] aClass : classes) {
            res += (double) aClass[0] / aClass[1];
        }
        return res / classes.length;
    }
}
