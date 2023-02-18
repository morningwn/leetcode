package com.github.morningwn.to_offer.t031_t040;

/**
 * @author morningwn
 * @description: 数组中出现次数超过一半的数字
 * @date Created in 2020/7/11 23:39
 * @version: 1.0
 */
public class T0039 {

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
}
