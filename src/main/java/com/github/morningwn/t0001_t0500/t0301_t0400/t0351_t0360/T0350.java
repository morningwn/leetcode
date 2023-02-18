package com.github.morningwn.t0001_t0500.t0301_t0400.t0351_t0360;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author morningwn
 * @description: 两个数组的交集 II
 * @date Created in 2020/7/13 11:19
 * @version: 1.0
 */
public class T0350 {

    public T0350() {

    }

    /**
     * @author morningwn
     * @date 2020/7/13 11:38
     * @description: 先排序，然后使用双指针
     * @param: nums1
     * @param: nums2
     * @return: int[]
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] nums = new int[Math.min(nums1.length, nums2.length)];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return Arrays.copyOfRange(nums, 0, k);
    }

    /**
     * @author morningwn
     * @date 2020/7/13 11:26
     * @description: 使用字典存储数据的位置
     * @param: nums1
     * @param: nums2
     * @return: int[]
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> dir = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            dir.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            int index = dir.indexOf(nums2[i]);
            if (index != -1) {
                dir.remove(index);
                res.add(nums2[i]);
            }
        }

        int[] nums = new int[res.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res.get(i);
        }
        return nums;
    }
}
