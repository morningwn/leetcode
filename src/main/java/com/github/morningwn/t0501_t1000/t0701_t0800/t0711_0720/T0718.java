package com.github.morningwn.t0501_t1000.t0701_t0800.t0711_0720;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/maximum-length-of-repeated-subarray/">718. 最长重复子数组</a>
 *
 * @author morningwn
 * @date Created in 2020/7/1 15:49
 */
public class T0718 {

    @Test
    public void test() {
        int[] A = {0, 1, 1, 1, 1};
        int[] B = {1, 0, 1, 0, 1};
        Out.println(findLength(A, B));
    }

    public int findLength(int[] A, int[] B) {
        int[][] counts = new int[A.length + 1][B.length + 1];
        int res = 0;

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    counts[i][j] = counts[i - 1][j - 1] + 1;

                } else {
                    counts[i][j] = 0;
                }
                res = Math.max(res, counts[i][j]);

            }
        }

        return res;
    }

}
