package com.github.morningwn.t1001_t1500.t1001_t1100.t1001_t1010;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/">1005. K 次取反后最大化的数组和</a>
 *
 * @author morningwn
 * @date Created in 2021/12/3 14:25
 */
public class T1005 {

    @Test
    public void test() {
        int[] nums = {3, -1, 0, 2};
        int k = 3;

        Out.println(largestSumAfterKNegations(nums, k));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] counts = new int[201];

        for (int num : nums) {
            counts[num + 100] += 1;
        }

        for (int i = 0; i < 100 && k > 0; i++) {
            if (counts[i] <= k) {
                k -= counts[i];
                counts[200 - i] += counts[i];
                counts[i] = 0;
            } else {
                counts[i] -= k;
                counts[200 - i] += k;
                k = 0;
            }
        }

        int index = 101;
        int res = 0;
        if (k % 2 == 1 && counts[100] == 0) {
            while (counts[index] == 0) {
                index++;
            }
            counts[index]--;
            res -= index - 100;
        } else {
            index = 0;
        }

        for (; index < counts.length; index++) {
            if (counts[index] != 0) {
                res += counts[index] * (index - 100);
            }
        }

        return res;
    }

    /**
     * 无脑循环
     *
     * @param nums
     * @param k
     * @return
     */
    public int largestSumAfterKNegations1(int[] nums, int k) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length && k > 0 && nums[i] <= 0; i++, k--) {
            nums[i] = -nums[i];
        }

        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }

        return Arrays.stream(nums).sum();
    }
}
