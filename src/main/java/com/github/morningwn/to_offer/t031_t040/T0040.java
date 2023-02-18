package com.github.morningwn.to_offer.t031_t040;

import java.util.Arrays;

/**
 * @author morningwn
 * @description: 最小的k个数
 * @date Created in 2020/7/11 23:39
 * @version: 1.0
 */
public class T0040 {

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);

        System.arraycopy(arr, 0, res, 0, k);

        return res;
    }
}
