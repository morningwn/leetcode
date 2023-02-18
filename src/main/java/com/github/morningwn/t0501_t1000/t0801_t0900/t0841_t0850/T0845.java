package com.github.morningwn.t0501_t1000.t0801_t0900.t0841_t0850;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date 2020/10/25 22:26
 */
public class T0845 {

    @Test
    public void test() {
        int[] A = {2, 2, 2};

        Out.println(longestMountain(A));
    }

    public int longestMountain(int[] A) {
        int length = A.length;

        int[][] counts = new int[length][2];

        for (int i = 1; i < length; i++) {
            if (A[i] > A[i - 1]) {
                counts[i][0] = counts[i - 1][0] + 1;
            } else {
                counts[i][0] = 0;
            }

            if (A[length - i - 1] > A[length - i]) {
                counts[length - i - 1][1] = counts[length - i][1] + 1;
            } else {
                counts[length - i - 1][1] = 0;
            }
        }

        int res = 0;

        for (int i = 0; i < length; i++) {
            int tmp = counts[i][0] + counts[i][1] + 1;
            if (counts[i][0] > 0 && counts[i][1] > 0 && tmp > res) {
                res = tmp;
            }
        }

        return res;
    }
}
