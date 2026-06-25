package com.github.morningwn.t1501_t2000.t1501_t1600.t1501_t1510;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/can-make-arithmetic-progression-from-sequence/">1502. 判断能否形成等差数列</a>
 *
 * @author morningwn
 * @date Created in 2020/7/5 10:32
 */
public class J1502 {

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
