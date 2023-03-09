package com.github.morningwn.t1501_t2000.t1501_t1600.t1501_t1510;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/range-sum-of-sorted-subarray-sums/">1508. 子数组和排序后的区间和</a>
 *
 * @author morningwn
 * @date Created in 2023/3/3 22:24
 */
public class T1508 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 34, 54, 23, 5, 6, 4, 3, 4, 34, 66, 76, 45, 34, 65, 34, 65, 76, 45, 23, 65, 56, 8, 9, 43, 90, 23, 73, 94, 23, 98, 43, 76, 34, 78, 73, 8, 2, 86, 34, 76, 34, 87, 43};
        Out.println(nums.length);
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        int length = n * (n + 1) / 2;
        int[] sumArr = new int[length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                sumArr[index++] = sum;
            }
        }
        int rangeSum = 0;
        Arrays.sort(sumArr);
        final int MOD = 1000000007;
        for (int i = left; i <= right; i++) {
            rangeSum = (rangeSum + sumArr[i]) % MOD;
        }

        return rangeSum;
    }
}
