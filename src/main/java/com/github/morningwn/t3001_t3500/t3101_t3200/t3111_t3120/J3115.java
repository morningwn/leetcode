package com.github.morningwn.t3001_t3500.t3101_t3200.t3111_t3120;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/maximum-prime-difference/description/">3115. 质数的最大距离</a>
 *
 * @author morningwn
 * @date 2024-07-02 15:59:24
 */
public class J3115 {

    @Test
    public void test() {
        int res = 0;
        res = maximumPrimeDifference(new int[]{4, 2, 3, 4, 6, 7, 6, 5, 4, 2});
        Assert.assertEquals(8, res);
        res = maximumPrimeDifference(new int[]{2, 2});
        Assert.assertEquals(1, res);

    }

    public int maximumPrimeDifference(int[] nums) {
        int[] primeSet = getPrimeSet(100);

        int firstPrimeIndex = -1;
        int lastPrimeIndex = -1;

        for (int i = 0, j = nums.length - 1; j > -1; i++, j--) {
            if (firstPrimeIndex == -1 && primeSet[nums[i]] == 0) {
                firstPrimeIndex = i;
            }
            if (lastPrimeIndex == -1 && primeSet[nums[j]] == 0) {
                lastPrimeIndex = j;
            }
            if (firstPrimeIndex != -1 && lastPrimeIndex != -1) {
                return lastPrimeIndex - firstPrimeIndex;
            }
        }

        return 0;
    }

    private int[] getPrimeSet(int n) {
        int[] flags = new int[n + 1];
        flags[0] = 1;
        flags[1] = 1;

        for (int i = 2; i * i <= n; i++) {
            if ((flags[i] & 1) != 0) {
                continue;
            }
            for (int j = i + i; j <= n; j += i) {
                flags[j] = 1;
            }
        }
        return flags;
    }
}