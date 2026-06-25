package com.github.morningwn.t1001_t1500.t1401_t1500.t1441_t1450;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/">1442. 形成两个异或相等数组的三元组数目</a>
 *
 * @author morningwn
 * @date Created in 2020/5/10 10:49
 */
public class J1442 {
    @Test
    public void test() {
//        int[] arr = {2,3,1,6,7};//4
//        int[] arr = {1,1,1,1,1};//10
//        int[] arr = {1,3,5,7,9};//3
        int[] arr = {7, 11, 12, 9, 5, 2, 7, 17, 22};//8
        Out.println(countTriplets(arr));
    }

    public int countTriplets(int[] arr) {
        int res = 0;

        for (int i = 2; i <= arr.length; i++) {
            for (int j = 0; j <= arr.length - i; j++) {
                res += getOne(Arrays.copyOfRange(arr, j, i + j));
            }
        }

        return res;
    }

    public int getOne(int[] arr) {
        int len = arr.length;
        int res = 0;
        int[] a = new int[len];
        int[] b = new int[len];

        a[0] = arr[0];
        b[len - 1] = arr[len - 1];
        for (int i = 1; i < len; i++) {
            a[i] = a[i - 1] ^ arr[i];
            b[len - 1 - i] = arr[len - 1 - i] ^ b[len - i];
        }

        for (int i = 0; i < len - 1; i++) {
            if (a[i] == b[i + 1]) {
                res++;
            }
        }

        return res;
    }
}
