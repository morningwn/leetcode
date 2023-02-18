package com.github.morningwn.t1001_t1500.t1401_t1500.t1411_t1420;

/**
 * <a href="https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/">1413. 逐步求和得到正数的最小值</a>
 *
 * @author morningwn
 * @create in 2022/8/4 15:56
 */
public class T1413 {

    public int minStartValue(int[] nums) {
        int minPrefix = Integer.MAX_VALUE;
        int tmp = 0;

        for (int num : nums) {
            tmp += num;
            if (minPrefix > tmp) {
                minPrefix = tmp;
            }
        }

        if (minPrefix > 0) {
            return 1;
        } else {
            return 1 - minPrefix;
        }

    }
}
