package com.github.morningwn.t0001_t0500.t0101_t0200.t0161_t0170;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

public class T0169 {

    @Test
    public void test() {
//        int[] nums = {3,2,3};       //3
        int[] nums = {1, 2, 3, 4, 2, 2, 3, 3, 2, 3, 3};
//        int[] nums = {2,2,1,1,1,2,2, 1, 1 };   //1
        Out.println(majorityElement(nums));
    }

    //用点脑子的，这个更优
    public int majorityElement(int[] nums) {

        int res = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {

            if (res == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    res = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }

        return res;
    }

    //无脑法
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

}
