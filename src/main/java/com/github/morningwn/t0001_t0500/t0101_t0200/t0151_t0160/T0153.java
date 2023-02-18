package com.github.morningwn.t0001_t0500.t0101_t0200.t0151_t0160;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 寻找旋转排序数组中的最小值
 *
 * @author morningwn
 * @version 1.0.0
 * @date 2021/4/9 16:38
 */
public class T0153 {

    @Test
    public void test() {

        int[] nums = {2, 3, 1};

        Out.println(findMin(nums));
    }

    /**
     * 非递归，最优解
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (end > start + 1) {

            int middle = (start + end) / 2;

            if (nums[start] > nums[end]) {
                //整体无序
                if (nums[start] < nums[middle]) {
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

    public int findMin1(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.min(nums[start], nums[end]);
        }

        int middle = (start + end) / 2;

        if (nums[start] > nums[end]) {
            //整体无序

            if (nums[start] < nums[middle]) {
                //前半截有序
                return helper(nums, middle, end);
            } else {
                //后半截有序
                return helper(nums, start, middle);
            }
        } else {
            //整体有序

            return nums[start];
        }
    }
}
