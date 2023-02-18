package com.github.morningwn.t1001_t1500.t1301_t1400;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T1304 {

    @Test
    public void test() {

        for (int num : sumZero(4)) {
            Out.println(num + "\t ");
        }
    }

    public int[] sumZero(int n) {

        if (n == 0) {
            return new int[0];
        }
        int[] nums = new int[n];
        int lastNum = 0;

        for (int i = 1; i < n; i++) {
            nums[i - 1] = i;
            lastNum += i;
        }
        nums[n - 1] = -lastNum;

        return nums;
    }

}
