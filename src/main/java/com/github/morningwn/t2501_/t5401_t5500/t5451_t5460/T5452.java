package com.github.morningwn.t2501_.t5401_t5500.t5451_t5460;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author morningwn
 * @date Created in 2020/7/5 10:32
 */
public class T5452 {

    @Test
    public void test() {

        int[] arr = {1, 2, 4};

        Out.println(canMakeArithmeticProgression(arr));
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (d + arr[i - 1] != arr[i]) {
                return false;
            }
        }

        return true;
    }

}
