package com.github.morningwn.t2001_t2500.t2301_t2400.t2351_t2360;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/">2357. 使数组中所有元素都等于零</a>
 *
 * @author morningwn
 * @create in 2023/2/24 14:27
 */
public class T2357 {

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num != 0) {
                set.add(num);
            }
        }

        return set.size();
    }
}
