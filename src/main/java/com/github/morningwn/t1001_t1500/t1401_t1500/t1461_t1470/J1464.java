package com.github.morningwn.t1001_t1500.t1401_t1500.t1461_t1470;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;


/**
 * <a href="https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/">1464. 数组中两元素的最大乘积</a>
 * <ul>
 * <li>{@link Difficulty#Easy}</li>
 * <li>{@link Topic#Array}</li>
 * <li>{@link Topic#Sorting}</li>
 * <li>{@link Topic#PriorityQueue}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2022-08-26 19:16:36
 */
public class J1464 {

    @Test
    public void test() {
        int[] nums = {3, 4, 5, 2, 5, 4, 5, 5, 4, 5, 5, 4, 5, 5, 4, 5, 5, 4, 5, 5, 6, 56, 45, 34, 65, 34, 23, 4, 456, 234, 12, 23, 341, 23};
        Out.println(maxProduct(nums));

    }

    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int num : nums) {
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max2 - 1) * (max1 - 1);
    }

}
