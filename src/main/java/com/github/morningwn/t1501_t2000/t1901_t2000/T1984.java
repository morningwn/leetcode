package com.github.morningwn.t1501_t2000.t1901_t2000;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/">1984. 学生分数的最小差值</a>
 *
 * @author morningwn
 * @date 2022-02-11 10:39:09
 */
public class T1984 {


    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        for (int i = k - 1; i < nums.length; i++) {
            min = Math.min(min, nums[i] - nums[i - k + 1]);
        }

        return min;
    }
}
