package com.github.morningwn.t0001_t0500.t0001_t0100.t0031_t0040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author morningwn
 * @date 2020/11/10 8:39
 */
public class T0031 {

    @Test
    public void test() {
//        int[] nums = {3,2,1,4,3,2,2,1};
        int[] nums = {4, 2, 0, 2, 3, 2, 0};
        nextPermutation(nums);

        Out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = 0;

        flag:
        for (int i = len - 1; i >= 0; i--) {

            for (int j = len - 1; j >= i; j--) {
                index = j - 1;
                for (; index >= i; index--) {
                    if (nums[j] > nums[index]) {
                        int tmp = nums[j];
                        nums[j] = nums[index];
                        nums[index] = tmp;
                        break flag;
                    }
                }
            }

        }

        Arrays.sort(nums, index + 1, nums.length);

    }
}
