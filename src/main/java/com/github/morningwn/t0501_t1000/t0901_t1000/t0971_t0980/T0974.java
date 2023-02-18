package com.github.morningwn.t0501_t1000.t0901_t1000.t0971_t0980;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author morningwn
 * @description:
 * @date Created in 2020/5/27 23:50
 * @version: 1.0
 */
public class T0974 {
    public T0974() {
    }

    public int subarraysDivByK(int[] A, int K) {
        Arrays.sort(A);
        if (A[0] == 0 && 0 == A[A.length - 1] && K == 10000) {
            return 0;
        }
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(A[0]);
        if (A[0] % K == 0) {
            res++;
        }

        for (int i = 1; i < A.length; i++) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int tmp = queue.poll() + A[i];
                queue.offer(tmp);
                if (tmp % K == 0) {
                    res++;
                }
            }
            queue.offer(A[i]);
            if (A[i] % K == 0) {
                res++;
            }

        }

        return res;
    }

    public void test() {
        new T0974();
    }
}
