package com.github.morningwn.t0001_t0500.t0001_t0100.t0001_t0010;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/">4. 寻找两个正序数组的中位数</a>
 *
 * @author morningwn
 * @date
 */
public class T0004 {

    @Test
    public void test() {
        int[] nums1 = {};
        int[] nums2 = {};

        Out.println(findMedianSortedArrays(nums1, nums2));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length = nums1.length + nums2.length;

        int median1 = Integer.MIN_VALUE;
        int median2 = 0;

        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums1.length == 0 ? nums2[0] : nums1[0];
        }

        if (nums1.length == 0 && length > 1) {
            median1 = nums2[(length - 1) / 2];
            median2 = nums2[(length + 1) / 2];
            return (length + 1) % 2 == 0 ? median1 : (median1 + median2) / 2.0;
        } else if (nums2.length == 0 && length > 1) {
            median1 = nums1[(length - 1) / 2];
            median2 = nums1[(length + 1) / 2];
            return (length + 1) % 2 == 0 ? median1 : (median1 + median2) / 2.0;
        }

        for (int count = 0, i = 0, j = 0; count < (length + 1) / 2.0; count++) {

            if (i < nums1.length && j < nums2.length) {

                if (nums1[i] < nums2[j]) {
                    median2 = median1;
                    median1 = nums1[i];
                    i++;
                } else {
                    median2 = median1;
                    median1 = nums2[j];
                    j++;
                }
            } else if (i >= nums1.length && j < nums2.length) {

                if (nums1[nums1.length - 1] > nums2[j]) {
                    median2 = median1;
                    median1 = nums1[nums1.length - 1];
                    i++;
                } else {
                    median2 = median1;
                    median1 = nums2[j];
                    j++;
                }
            } else if (i < nums1.length && j >= nums2.length) {

                if (nums1[i] < nums2[nums2.length - 1]) {
                    median2 = median1;
                    median1 = nums2[nums2.length - 1];
                    j++;
                } else {
                    median2 = median1;
                    median1 = nums1[i];
                    i++;
                }

            }

        }
        return (length + 1) % 2 == 0 ? median1 : (median1 + median2) / 2.0;
    }

}
