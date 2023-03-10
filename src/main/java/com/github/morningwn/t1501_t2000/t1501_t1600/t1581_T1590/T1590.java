package com.github.morningwn.t1501_t2000.t1501_t1600.t1581_T1590;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/make-sum-divisible-by-p/">1590. 使数组和能被 P 整除</a>
 *
 * @author morningwn
 * @date Created in 2023/3/10 14:59
 */
public class T1590 {

    @Test
    public void test() {
        int[] nums = {1000000000, 1000000000, 1000000000};
        int p = 3;
        int minSubarray = minSubarray(nums, p);
        Out.println(minSubarray);
    }

    public int minSubarray(int[] nums, int p) {
        /**
         * (s1 - s2) % p == 0
         * s1 % p = s2 % p = x
         * x = (sum[0-j] - sum[0-i]) % p
         * x = sum[0-j] % p - sum[0-i] % p
         * sum[0-j] % p = x + sum[0-i] % p
         * sum[0-j] % p = (x + sum[0-i]) % p
         */
        int x = 0;
        for (int num : nums) {
            x = (x + num) % p;
        }
        int minSubarray = nums.length;
        int prefixSumMod = 0;

        Map<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixSumMod = (nums[i] + prefixSumMod) % p;
            modMap.put(prefixSumMod, i);
            int target = (prefixSumMod - x + p) % p;
            if (modMap.containsKey(target)) {
                minSubarray = Math.min(minSubarray, i - modMap.get(target));
            }
        }

        return minSubarray == nums.length ? -1 : minSubarray;
    }
}
