package com.github.morningwn.t0501_t1000.t0901_t1000.t0981_t0990;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/">982. 按位与为零的三元组</a>
 *
 * @author morningwn
 * @date Created in 2023/3/4 11:49
 */
public class T0982 {

    @Test
    public void test() {
        Out.println(2 << 17);
        int[] nums = {1, 2, 3, 4};
        int i = countTriplets(nums);
        Out.println(i);

        int num = 12;
        Out.println(Integer.toBinaryString(num));
        while (num != 0) {
            Out.println(Integer.toBinaryString(num));
            num = 12 & (num - 1);
        }
    }

    public int countTriplets(int[] nums) {
        int[] counts = new int[1 << 16];

        for (int k : nums) {
            for (int num : nums) {
                counts[k & num]++;
            }
        }

        int triplets = 0;
        for (int num : nums) {
            int target = num ^ 0xffff;
            int tmp = target;
            while (tmp != 0) {
                triplets += counts[tmp];
                tmp = target & (tmp - 1);
            }
            triplets += counts[0];
        }
        return triplets;
    }
}
