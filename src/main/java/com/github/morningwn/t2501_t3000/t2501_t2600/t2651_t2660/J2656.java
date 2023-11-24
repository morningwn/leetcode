package com.github.morningwn.t2501_t3000.t2501_t2600.t2651_t2660;

/**
 * <a href="https://leetcode.cn/problems/maximum-sum-with-exactly-k-elements/">2656. K 个元素的最大和</a>
 *
 * @author morningwn
 * @date 2023/11/15 10:33
 */
public class J2656 {
    public int maximizeSum(int[] nums, int k) {
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        return maxValue * k + ((k - 1) * k) / 2;
    }
}
