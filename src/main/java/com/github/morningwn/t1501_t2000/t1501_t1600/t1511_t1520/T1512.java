package com.github.morningwn.t1501_t2000.t1501_t1600.t1511_t1520;

/**
 * <a href="https://leetcode.cn/problems/number-of-good-pairs/">1512. 好数对的数目</a>
 *
 * @author morningwn
 * @date Created in 2020/7/20 17:32
 */
public class T1512 {

    public int numIdenticalPairs(int[] nums) {
        int[] counts = new int[101];
        int res = 0;
        for (int num : nums) {
            counts[num]++;
        }

        for (int count : counts) {
            res += count * (count - 1) / 2;
        }

        return res;
    }
}
