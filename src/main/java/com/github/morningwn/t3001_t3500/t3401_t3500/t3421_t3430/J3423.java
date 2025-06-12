package com.github.morningwn.t3001_t3500.t3401_t3500.t3421_t3430;

/**
 * <a href="https://leetcode.cn/problems/maximum-difference-between-adjacent-elements-in-a-circular-array">3423. 循环数组中相邻元素的最大差值</a>
 *
 * @author morningwn
 * @date 2025-06-12 09:38
 */
public class J3423 {
    public int maxAdjacentDistance(int[] nums) {
        int maxDistance = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int tmp = Math.abs(nums[i] - nums[(i+1)%length]);
            if (tmp > maxDistance) {
                maxDistance = tmp;
            }
        }
        return maxDistance;
    }
}