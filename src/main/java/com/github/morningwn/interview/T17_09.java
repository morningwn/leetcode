package com.github.morningwn.interview;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/get-kth-magic-number-lcci/">面试题 17.09. 第 k 个数</a>
 *
 * @author morningwn
 * @create in 2022/9/28 11:35
 */
public class T17_09 {

    @Test
    public void test() {
        for (int i = 1; i < 11; i++) {
            Out.printlnf("i: %d, res: %d", i, getKthMagicNumber(i));
        }
    }

    public int getKthMagicNumber(int k) {
        int ai = 1;
        int bi = 1;
        int ci = 1;
        int[] nums = new int[k + 1];
        nums[1] = 1;
        for (int i = 2; i <= k; i++) {
            int a = 3 * nums[ai];
            int b = 5 * nums[bi];
            int c = 7 * nums[ci];
            nums[i] = Math.min(a, Math.min(b, c));

            if (nums[i] == a) {
                ai++;
            }
            if (nums[i] == b) {
                bi++;
            }
            if (nums[i] == c) {
                ci++;
            }
        }
        return nums[k];
    }
}
