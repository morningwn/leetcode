package com.github.morningwn.t0001_t0500.t0001_t0100.t0081_t0090;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array/description/">88. 合并两个有序数组</a>
 *
 * @author morningwn
 * @date Created in 2020/7/19 17:52
 */
public class J0088 {

    @Test
    public void test() {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int index = (m + n) - 1;

        while (j >= 0) {
            if (i >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[index--] = nums1[i--];
                } else {
                    nums1[index--] = nums2[j--];
                }
            } else {
                nums1[index--] = nums2[j--];
            }
        }
    }
}
