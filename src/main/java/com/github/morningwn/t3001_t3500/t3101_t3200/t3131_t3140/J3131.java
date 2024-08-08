package com.github.morningwn.t3001_t3500.t3101_t3200.t3131_t3140;

/**
 * <a href="https://leetcode.cn/problems/find-the-integer-added-to-array-i/">3131. 找出与数组相加的整数 I</a>
 *
 * @author morningwn
 * @date 2024-08-08 17:24:24
 */
public class J3131 {

    public int addedInteger(int[] nums1, int[] nums2) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            min1 = Math.min(min1, nums1[i]);
            min2 = Math.min(min2, nums2[i]);
        }

        return min2 - min1;
    }
}