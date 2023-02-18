package com.github.morningwn.t0001_t0500.t0301_t0400.t0321_t0330;

/**
 * 区间和的个数
 *
 * @author morningwn
 * @date 2020/11/7 11:23
 */
public class T0327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            long tmp = nums[i];
            if (lower <= tmp && tmp <= upper) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                tmp += nums[j];
                if (lower <= tmp && tmp <= upper) {
                    count++;
                }
            }
        }

        return count;
    }
}
