package com.github.morningwn.t0001_t0500.t0401_t0500.t0461_t0470;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/">462. 最少移动次数使数组元素相等 II</a>
 *
 * @author moringwn
 * @create in 2022/5/19 16:37
 */
public class T0462 {

    @Test
    public void test() {
        int[] nums = {7, 12, 65, 21, 1, 6, 8, 5};

        Out.println(minMoves2(nums));
        Arrays.sort(nums);
        Out.println(Arrays.toString(nums));
    }

    public int minMoves2(int[] nums) {
        int sum = 0;
        int mid = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }

            mid = nums[i];
        }

        for (int num : nums) {
            sum += Math.abs(num - mid);
        }

        return sum;
    }
}
