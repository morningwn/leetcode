package com.github.morningwn.t0501_t1000.t0701_t0800.t0711_0720;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/find-k-th-smallest-pair-distance/">719. 找出第 K 小的数对距离</a>
 *
 * @author moringwn
 * @create in 2022/6/15 9:48
 */
public class T0719 {

    @Test
    public void test() {
        int[] nums = {1, 6, 1};
        int k = 3;
        Out.println(smallestDistancePair(nums, k));
    }

    public int smallestDistancePair(int[] nums, int k) {
        int[] countSize = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    countSize[nums[i] - nums[j]] += 1;
                } else {
                    countSize[nums[j] - nums[i]] += 1;
                }
            }
        }

        int n = 0;
        for (int i = 0; i < countSize.length; i++) {
            if (countSize[i] != 0) {
                n += countSize[i];
                if (n >= k) {
                    return i;
                }
            }
        }

        return 0;
    }
}
