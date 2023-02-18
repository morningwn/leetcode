package com.github.morningwn.t1001_t1500.t1401_t1500.t1461_t1470;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/">1464. 数组中两元素的最大乘积</a>
 *
 * @author morningwn
 * @create in 2022/8/26 19:10
 */
public class T1464 {
    @Test
    public void test() {
        int[] nums = {3, 4, 5, 2, 5, 4, 5, 5, 4, 5, 5, 4, 5, 5, 4, 5, 5, 4, 5, 5, 6, 56, 45, 34, 65, 34, 23, 4, 456, 234, 12, 23, 341, 23};
        Out.println(maxProduct(nums));

    }

    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int num : nums) {
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            }else if (num > max2) {
                max2 = num;
            }
        }

        return (max2 - 1) * (max1 - 1);
    }
}
