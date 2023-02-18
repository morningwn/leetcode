package com.github.morningwn.t0001_t0500.t0201_t0300.t0291_t0300;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">300. 最长递增子序列</a>
 *
 * @author morningwn
 * @date 2020/9/8  22:15
 */
public class T0300 {

    @Test
    public void test() {
        int[] nums = {4, 10, 4, 3, 8, 9};

        Out.println(lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] counts = new int[nums.length];
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            counts[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    counts[i] = Math.max(counts[i], counts[j] + 1);
                }
            }
            maxCount = Math.max(maxCount, counts[i]);
        }
        return maxCount;
    }
}
