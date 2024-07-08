package com.github.morningwn.t0501_t1000.t0701_t0800.t0721_t0730;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/find-pivot-index/description/">724. 寻找数组的中心下标</a>
 *
 * @author moringwn
 * @date 2024/07/08 16:06
 */
public class J0724 {

    @Test
    public void test() {
        Assert.assertEquals(3, pivotIndex(new int[]{1,7,3,6,5,6}));
    }

    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}