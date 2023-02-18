package com.github.morningwn.to_offer.t001_t010;

import java.util.HashSet;
import java.util.Set;

/**
 * @author morningwn
 * @description: 找到数组中的重复数字
 * @date Created in 2020/6/30 16:21
 * @version: 1.0
 */
public class T003 {

    public T003() {

    }

    /**
     * @param nums
     * @return int
     * @author morningwn
     * @date 2020/6/30 16:33
     * @description: 原地置换假设数组不出现重复数数字的话，排序后第i个数的值就是i
     */
    public int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }

        return -1;
    }

    /**
     * @param nums
     * @return int
     * @author morningwn
     * @date 2020/6/30 16:26
     * @description: 数组实现
     * @version: 2.0
     */
    public int findRepeatNumber2(int[] nums) {
        int[] counts = new int[nums.length];

        for (int num : nums) {
            if (counts[num]++ > 0) {
                return num;
            }
        }

        return -1;
    }

    /**
     * @param nums
     * @return int
     * @author morningwn
     * @date 2020/6/30 16:22
     * @description: 找到数组中的任意一个重复的数字，集合实现
     * @version: 1.0
     */
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }

        return -1;
    }
}
