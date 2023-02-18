package com.github.morningwn.t0501_t1000.t0501_t0600.t0531_t0540;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/single-element-in-a-sorted-array/">540.有序数组中的单一元素</a>
 *
 * @author morningwn
 * @date 2022-02-14 09:54:18
 */
public class T0540 {


    @Test
    public void test() {
        int[] nums = {0, 0, 1, 1, 2, 3, 3, 4, 4, 8, 8};

        int n = singleNonDuplicate(nums);

        Out.println(n);
    }

    public int singleNonDuplicate(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (r >= l) {
            int m = (r + l) / 2;
            if (m % 2 == 0) {
                if (m - 1 >= 0 && nums[m - 1] == nums[m]) {
                    if (m + 1 < nums.length && nums[m + 1] == nums[m]) {
                        return nums[m];
                    } else {
                        r = m - 2;
                    }
                } else {
                    if (m + 1 < nums.length && nums[m + 1] == nums[m]) {
                        l = m + 2;
                    } else {
                        return nums[m];
                    }
                }
            } else {
                if (m - 1 >= 0 && nums[m - 1] == nums[m]) {
                    if (m + 1 < nums.length && nums[m + 1] == nums[m]) {
                        return nums[m];
                    } else {
                        l = m + 1;
                    }
                } else {
                    if (m + 1 < nums.length && nums[m + 1] == nums[m]) {
                        r = m - 1;
                    } else {
                        return nums[m];
                    }
                }
            }


        }
        return -1;
    }
}
