package com.github.morningwn.t0001_t0500.t0101_t0200.t0191_t0200;

/**
 * @author morningwn
 * @date 2020/8/31  19:48
 */
public class T0198 {

    public int rob(int[] nums) {
        int[] res = new int[nums.length + 2];

        for (int i = 0; i < nums.length; i++) {
            res[i + 2] = Math.max(res[i + 1], res[i] + nums[i]);
        }

        return res[nums.length + 1];
    }
}
