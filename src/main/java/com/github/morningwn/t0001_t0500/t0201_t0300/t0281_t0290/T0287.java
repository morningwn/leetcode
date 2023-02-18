package com.github.morningwn.t0001_t0500.t0201_t0300.t0281_t0290;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/5/26 9:55
 */
public class T0287 {
    @Test
    public void test() {
        int[] nums = {1, 3, 5, 3, 4, 2};
        Out.println(findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
            Out.println(xor + "\t " + num);
        }
        Out.println("_____________");
        for (int num : nums) {
            Out.println((xor ^= num) + "\t " + num + "\t " + xor);
        }
        return 0;
    }

    /**
     * 不符合题意的解法
     */
    public int findDuplicate1(int[] nums) {
        int[] counts = new int[nums.length];

        for (int num : nums) {
            counts[num]++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 1) {
                return i;
            }
        }
        return 0;
    }

}
