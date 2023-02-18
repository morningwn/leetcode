package com.github.morningwn.t0001_t0500.t0401_t0500.t0451_t0460;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 453. 最小操作次数使数组元素相等
 * <link>https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 *
 * @author moringwn
 * @date 2021/10/20 上午9:44
 */
public class T0453 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};

        Out.println(minMoves(nums));
    }

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (min > num) {
                min = num;
            }
        }

        return sum - nums.length * min;
    }
}
