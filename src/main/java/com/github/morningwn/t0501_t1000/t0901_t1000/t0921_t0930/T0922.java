package com.github.morningwn.t0501_t1000.t0901_t1000.t0921_t0930;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date 2020/11/12 8:52
 */
public class T0922 {

    @Test
    public void test() {
        int[] nums = {2, 1, 5, 9, 8, 3, 7, 4, 6, 10};
        sortArrayByParityII(nums);

        Out.println(nums);

    }

    public int[] sortArrayByParityII(int[] A) {
        int oddIndex = 1;
        int evenIndex = 0;
        int[] res = new int[A.length];

        for (int num : A) {
            if (num % 2 == 0) {
                res[evenIndex] = num;
                evenIndex += 2;
            } else {
                res[oddIndex] = num;
                oddIndex += 2;
            }
        }
        return res;
    }
}
