package com.github.morningwn.t1001_t1500.t1301_t1400.t1361_t1370;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.Arrays;


/**
 * <a href="https://leetcode.cn/problems/how-many-numbers-are-smaller-than-the-current-number/">1365. 有多少小于当前数字的数字</a>
 * <ul>
 * <li>{@link Difficulty#Easy}</li>
 * <li>{@link Topic#Array}</li>
 * <li>{@link Topic#HashTable}</li>
 * <li>{@link Topic#Counting}</li>
 * <li>{@link Topic#Sorting}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2020/7/21 16:35
 */
public class J1365 {

    @Test
    public void test() {
        int[] nums = {8, 1, 2, 2, 3};

        Out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] counts = new int[101];
        int[] res = new int[length];

        for (int num : nums) {
            counts[num]++;
        }

        for (int i = 1, next = 0; i < 101; i++) {
            int tmp = counts[i];
            counts[i] = next + counts[i - 1];
            next = tmp;
        }

        counts[0] = 0;
        Out.println(Arrays.toString(counts));
        for (int i = 0; i < length; i++) {
            res[i] = counts[nums[i]];
        }

        return res;
    }
}
