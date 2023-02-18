package com.github.morningwn.t0001_t0500.t0401_t0500.t0491_t0500;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a hreaf="https://leetcode-cn.com/problems/next-greater-element-i/">496. 下一个更大元素 I</a>
 *
 * @author moringwn
 * @date 2021/10/26 上午9:33
 */
public class T0496 {

    @Test
    public void test() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        Out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> dir = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.empty() && num >= stack.peek()) {
                stack.pop();
            }
            dir.put(num, stack.isEmpty() ? -1 : stack.peek());

            stack.push(num);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = dir.get(nums1[i]);
        }

        return res;
    }
}
