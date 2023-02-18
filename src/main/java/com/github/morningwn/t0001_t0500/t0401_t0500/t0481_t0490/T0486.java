package com.github.morningwn.t0001_t0500.t0401_t0500.t0481_t0490;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date 2020/9/1  11:17
 */
public class T0486 {

    @Test
    public void test() {
        int[] nums = {1, 5, 2};
        Out.println(PredictTheWinner(nums));
    }

    public boolean PredictTheWinner(int[] nums) {

        return helper(nums, 0, nums.length - 1, 1) >= 0;
    }

    public int helper(int[] nums, int i, int j, int turn) {
        if (i == j) {
            return nums[i] * turn;
        }

        int l = nums[i] * turn + helper(nums, i + 1, j, -turn);
        int r = nums[j] * turn + helper(nums, i, j - 1, -turn);

        return Math.max(l * turn, r * turn) * turn;
    }

}
