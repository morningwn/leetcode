package com.github.morningwn.t0001_t0500.t0201_t0300.t0231_t0240;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 滑动窗口最大值
 *
 * @author morningwn
 * @version 1.0
 * @date Created in 2020/8/10 11:08
 */
public class T0239 {

    @Test
    public void test() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    /**
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0, j = 0; i < nums.length; i++) {
        }

        return res;
    }
}
