package com.github.morningwn.t0001_t0500.t0201_t0300.t0211_t0220;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 打家劫舍 II
 * 实际上是01背包问题的变种
 *
 * @author morningwn
 * @version 1.0.0
 * @date 2021/4/15 22:20
 */
public class T0213 {

    @Test
    public void test() {
        int[] nums = {2, 3, 2, 4, 3};

        Out.println(rob(nums));
    }

    /**
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    public int helper(int[] nums, int start, int end) {

        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }

        return second;
    }

//    /**
//     * 递归超时了
//     * @param nums
//     * @return
//     */
//    public int rob(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
//    }
//
//    public int helper(int[] nums, int index, int end) {
//        if (index > end) {
//            return 0;
//        }
//
//        return Math.max(nums[index]+helper(nums, index+2, end), helper(nums, index+1, end));
//    }
}
