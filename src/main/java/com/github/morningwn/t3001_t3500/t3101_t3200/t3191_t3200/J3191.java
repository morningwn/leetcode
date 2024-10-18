package com.github.morningwn.t3001_t3500.t3101_t3200.t3191_t3200;


import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i">3191. 使二进制数组全部等于 1 的最少操作次数 I</a>
 *
 * @author morningwn
 * @date 2024-10-18 11:12:24
 */
public class J3191 {

    @Test
    public void test() {
        int[] nums = {0, 1, 1, 1, 0, 0};
        Out.print(minOperations(nums));
    }

    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                if (i + 3 > nums.length) {
                    return -1;
                }
                for (int j = i; j < i + 3; j++) {
                    if (nums[j] == 1) {
                        nums[j] = 0;
                    } else {
                        nums[j] = 1;
                    }
                }
                count++;
            }
        }

        return count;
    }

}