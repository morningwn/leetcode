package com.github.morningwn.t1001_t1500.t1401_t1500.t1401_t1410;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/">1403. 非递增顺序的最小子序列</a>
 *
 * @author morningwn
 * @create in 2022/8/4 15:36
 */
public class J1403 {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        List<Integer> list = new ArrayList<>();
        int tmp = 0;
        for (int i = nums.length - 1; i > -1; i--) {
            tmp += nums[i];
            sum -= nums[i];
            list.add(nums[i]);
            if (tmp > sum) {
                return list;
            }
        }

        return list;
    }
}
