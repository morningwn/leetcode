package com.github.morningwn.t0001_t0500.t0101_t0200.t0151_t0160;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/5/18 14:48
 */
public class T0152 {

    @Test
    public void test() {
        int[] nums = {2};        //2
//        int[] nums = {2,3,-2,4};        //6
//        int[] nums = {-2,0,-1};        //0

        Out.println(maxProduct1(nums));
    }

    /**
     * 最简单的，暴力循环
     *
     * @param nums 一个数组
     * @return 最大的连续乘积
     */
    public int maxProduct1(int[] nums) {

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int[] count = new int[nums.length - i + 1];
            count[0] = 1;
            for (int j = 1; j + i - 1 < nums.length; j++) {
                count[j] = count[j - 1] * nums[j + i - 1];
                res = Math.max(count[j], res);
            }
        }
        return res;
    }

}
