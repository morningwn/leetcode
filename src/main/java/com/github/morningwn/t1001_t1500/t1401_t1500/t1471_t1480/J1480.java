package com.github.morningwn.t1001_t1500.t1401_t1500.t1471_t1480;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/running-sum-of-1d-array/">1480. 一维数组的动态和</a>
 * @author morningwn
 * @date Created in 2020/7/19 18:02
 */
public class J1480 {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 3, 6, 10}, runningSum(new int[]{1, 2, 3, 4}));
    }

    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i] + res[i - 1];
        }

        return res;
    }
}
