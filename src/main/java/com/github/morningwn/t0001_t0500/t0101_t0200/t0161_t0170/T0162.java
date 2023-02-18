package com.github.morningwn.t0001_t0500.t0101_t0200.t0161_t0170;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author moringwn
 * @date 2021/9/15 上午9:29
 */
public class T0162 {

    @Test
    public void test() {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};

        Out.println(findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int length = nums.length;

        int l = 0;
        int r = length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] > nums[(m + 1) % length]) {
                if (nums[m] > nums[(length + m - 1) % length]) {
                    return m;
                } else {
                    r = m - 1;
                }
            } else {
                l = m + 1;
            }
        }

        return 0;
    }
}