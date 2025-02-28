package com.github.morningwn.t2001_t2500.t2001_t2100.t2001_t2010;

/**
 * <a href="https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/">2006. 差的绝对值为 K 的数对数目</a>
 *
 * @author morningwn
 * @date 2022-02-09 10:19:12
 */
public class J2006 {

    public int countKDifference(int[] nums, int k) {
        int[] count = new int[101];

        for (int num : nums) {
            count[num] += 1;
        }

        int res = 0;

        for (int i = 0; i + k < 101; i++) {
            res += count[i] * count[i + k];
        }

        return res;
    }
}
