package com.github.morningwn.t1501_t2000.t1501_t1600.t1571_t1580;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/description/"></a>
 *
 * @author morningwn
 * @date 2020/9/6  10:41
 */
public class J1577 {

    @Test
    public void test() {
        double a = 99908;
        double b = 1864;
        double c = a / b;

        Out.println(99908.0 / 1864.0);
        Out.println(1864 * 1864);
        Out.println(a / b == 53);
        Out.println(c);

    }

    public int numTriplets(int[] nums1, int[] nums2) {
        return helper(nums1, nums2) + helper(nums2, nums1);
    }

    public int helper(int[] nums1, int[] nums2) {
        int res = 0;

        for (int i = 0; i < nums1.length; i++) {
            int tmp = 0;

            for (int j = 0; j < nums2.length; j++) {
                for (int k = j + 1; k < nums2.length; k++) {
                    long a = (long) nums1[i] * (long) nums1[i];
                    long b = (long) nums2[k] * (long) nums2[j];
                    if (a == b) {
                        tmp++;
                    }
                }
            }
            int count = 1;
            while (i < nums1.length - 1 && nums1[i] == nums1[i + 1]) {
                i++;
                count++;
            }
            res += count * tmp;
        }

        return res;
    }
}
