package com.github.morningwn.t1501_t2000.t1801_t1900.t1821_t1830;

/**
 * <a href="https://leetcode.cn/problems/sign-of-the-product-of-an-array/">1822. 数组元素积的符号</a>
 *
 * @author morningwn
 * @date Created in 2022/10/27 10:31
 */
public class T1822 {
    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num > 0) {
                res *= 1;
            } else if (num < 0) {
                res *= -1;
            } else {
                return 0;
            }
        }

        return res;
    }
}
