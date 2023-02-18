package com.github.morningwn.t2501_.t5401_t5500.t5491_t5500;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date 2020/8/30  10:58
 */
public class T5500 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 5, -6, 4, 0, 10};
        Out.println(getMaxLen(nums));
    }

    public int getMaxLen(int[] nums) {
        int res = 0;
        int[] count = new int[nums.length];
        for (int i = 0; i < count.length; i++) {
            count[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > 0) {
                    count[j] *= 1;
                } else if (nums[i] < 0) {
                    count[j] *= -1;
                } else {
                    count[j] = 0;
                }
                if (count[j] > 0) {
                    res = Math.max(res, i - j + 1);
                }
            }
        }

        return res;
    }
}
