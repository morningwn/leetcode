package com.github.morningwn.t0001_t0500.t0001_t0100.t0001_t0010;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">1. 两数之和</a>
 *
 * @author morningwn
 * @date
 */
public class T0001 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    @Test
    public void test() {
        int target = 9;
        int[] nums = {2, 7, 2, 15};
        double T1 = System.nanoTime();
        Out.println(twoSum(nums, target)[0] + "  " + twoSum(nums, target)[1]);
        double T2 = System.nanoTime();
        Out.println((T2 - T1));
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] output = new int[2];
        HashMap<Integer, Integer> input = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            output[1] = i;
            if (input.containsKey(target - nums[i])) {
                output[0] = input.get(target - nums[i]);
                return output;
            } else {
                input.put(nums[i], i);
            }
        }
        return null;

    }

    public int[] twoSum2(int[] nums, int target) {

        int[] output = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    output[0] = i;
                    output[1] = j;
                    return output;
                }

            }
        }

        return output;

    }

}
