package com.github.morningwn.t0001_t0500.t0001_t0100.t0021_t0030;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">26. 删除有序数组中的重复项</a>
 *
 * @author morningwn
 * @date Created in
 */
public class T0026 {

    @Test
    public void test() {

        int[] nums = {1, 1, 2, 2, 3, 4, 5, 5};
        Out.println(removeDuplicates(nums));

        for (int i : nums) {
            Out.println(i);
        }

    }

    public int removeDuplicates(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }

        int len = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[len++] = nums[i];
            }
        }

        return len;

    }
}
