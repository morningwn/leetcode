package com.github.morningwn.t2501_t3000.t2901_t3000.t2951_t2960;

/**
 * <a href="https://leetcode.cn/problems/find-common-elements-between-two-arrays/description/">2956. 找到两个数组中的公共元素</a>
 *
 * @author morningwn
 * @date 2024-07-16 18:05:24
 */
public class J2956 {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] nums1Count = new int[101];
        for (int i : nums1) {
            nums1Count[i]++;
        }
        int answer1 = 0;
        int answer2 = 0;
        for (int num : nums2) {
            if (nums1Count[num] != 0 || nums1Count[num] == -1) {
                answer1 += Math.max(nums1Count[num], 0);
                nums1Count[num] = -1;
                answer2++;
            }
        }
        return new int[]{answer1, answer2};
    }
}