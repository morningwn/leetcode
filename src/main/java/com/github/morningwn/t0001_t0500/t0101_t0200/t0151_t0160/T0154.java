package com.github.morningwn.t0001_t0500.t0101_t0200.t0151_t0160;

/**
 * 寻找旋转排序数组中的最小值II
 *
 * @author morningwn
 * @version 1.0.0
 * @date 2021/4/9 16:36
 */
public class T0154 {

    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (end > start + 1) {

            //出现相等的情况，缩小区间
            while (start + 1 < end && nums[start] == nums[start + 1]) {
                start++;
            }
            while (end - 1 > start && nums[end] == nums[end - 1]) {
                end--;
            }
            if (nums[start] == nums[end]) {
                end--;
            }

            int middle = (start + end) / 2;

            if (nums[start] > nums[end]) {

                //整体无序
                if (nums[start] <= nums[middle]) {
                    //前半截有序
                    start = middle;
                } else {
                    //后半截有序
                    end = middle;
                }
            } else {
                //整体有序
                return nums[start];
            }
        }

        if (start == end) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.min(nums[start], nums[end]);
        }
        return 0;
    }
}
