package com.github.morningwn.t1001_t1500.t1401_t1500.t1471_t1480;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/the-k-strongest-values-in-an-array/">1471. 数组中的 k 个最强值</a>
 * @author morningwn
 * @create in 2023/1/29 22:15
 */
public class T1471 {

    @Test
    public void test() {
        int[] arr = {6,7,-11,7,6,8,7,6,43,3,2,1,3,-2,1,1,1,1,1,545,67,76,56,54,45,34,76,54,43,8,345,6535,8766,3243,7643,5479,3564,45,876,453};
        Out.println(getStrongest(arr, 12));
    }

    public int[] getStrongest(int[] arr, int k) {
        // 排序
        Arrays.sort(arr);
        // 计算中位数
        int median = arr[(arr.length - 1)/2];
        int[] res = new int[k];
        int rI = 0;
        int l = 0;
        int r = arr.length - 1;
        while (rI < k) {

            if (check(arr[l], arr[r], median) > -1) {
                res[rI++] = arr[l++];
            } else {
                res[rI++] = arr[r--];
            }
        }

        return res;
    }

    private int check(int a, int b, int m) {

        if (Math.abs(a - m) == Math.abs(b - m) && a > b) {
            return 1;
        }

        if (Math.abs(a - m) > Math.abs(b - m)) {
            return 1;
        }

        return -1;
    }
}
