package com.github.morningwn.t0501_t1000.t0901_t1000.t0941_t0950;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 给定数字能组成的最大时间
 *
 * @author morningwn
 * @date 2020/8/28  20:08
 */
public class T0949 {

    @Test
    public void test() {
        int[] nums = {2, 0, 6, 6};

        Out.println(largestTimeFromDigits(nums) + "sd");
    }

    public String largestTimeFromDigits(int[] A) {

        int max = -1;
        String res = "";

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    continue;
                }
                for (int m = 0; m < 4; m++) {
                    if (m == i || m == j) {
                        continue;
                    }
                    for (int n = 0; n < 4; n++) {
                        if (n == i || n == j || n == m) {
                            continue;
                        }
                        int hour = 10 * A[i] + A[j];
                        int minute = 10 * A[m] + A[n];

                        if (hour < 24 && minute < 60) {
                            int tmp = minute + 60 * hour;
                            if (tmp > max) {
                                max = tmp;
                                res = A[i] + "" + A[j] + ":" + A[m] + "" + A[n];
                            }
                        }
                    }
                }
            }
        }
        if (max >= 0) {
            return res;
        } else {
            return "";
        }
    }
}
