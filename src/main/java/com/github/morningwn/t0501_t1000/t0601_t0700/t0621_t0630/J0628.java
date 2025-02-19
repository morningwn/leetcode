package com.github.morningwn.t0501_t1000.t0601_t0700.t0621_t0630;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/maximum-product-of-three-numbers/">628. 三个数的最大乘积</a>
 *
 * @author morningwn
 * @date Created in 2023/3/5 23:10
 */
public class T0628 {

    @Test
    public void test() {
        int[] nums = {1,2,3};
        int i = maximumProduct(nums);
        Out.println(i);
    }

    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
