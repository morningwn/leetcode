package com.github.morningwn.t0001_t0500.t0101_t0200.t0131_t0140;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/5/14 0:20
 */
public class T0136 {
    @Test
    public void test() {
        int[] nums = {4, 1, 2, 1, 2};
        Out.println(singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int res = nums[0];
//        Out.println(res);

        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
//            Out.println(res);
        }
        return res;
    }
}
