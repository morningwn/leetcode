package com.github.morningwn.t1001_t1500.t1401_t1500.t1471_t1480;

import org.junit.Test;

/**
 * @author morningwn
 * @description: 一维数组的动态和
 * @date Created in 2020/7/19 18:02
 * @version: 1.0
 */
public class T1480 {

    @Test
    public void test() {

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
