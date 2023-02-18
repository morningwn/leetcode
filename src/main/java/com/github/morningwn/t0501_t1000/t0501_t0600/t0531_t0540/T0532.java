package com.github.morningwn.t0501_t1000.t0501_t0600.t0531_t0540;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/k-diff-pairs-in-an-array/">532. 数组中的 k-diff 数对</a>
 *
 * @author moringwn
 * @create in 2022/6/16 17:21
 */
public class T0532 {

    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);

        int j = 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[j] == nums[j - 1] || nums[i] + k < nums[j]) {
                j++;
            }
            if (nums[i] + k == nums[j]) {
                res++;
            }
        }

        return res;
    }
}
