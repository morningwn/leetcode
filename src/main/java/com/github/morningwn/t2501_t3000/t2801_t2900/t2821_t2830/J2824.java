package com.github.morningwn.t2501_t3000.t2801_t2900.t2821_t2830;

import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/">2824. 统计和小于目标的下标对数目</a>
 * <ul>
 * <li>{@link Difficulty#Easy}</li>
 * <li>{@link Topic#Array}</li>
 * <li>{@link Topic#TwoPointers}</li>
 * <li>{@link Topic#Sorting}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-11-24 10:15:24
 */
public class J2824 {

    @Test
    public void test() {

    }

    public int countPairs(List<Integer> nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    count++;
                }
            }
        }
        return count;
    }
}
