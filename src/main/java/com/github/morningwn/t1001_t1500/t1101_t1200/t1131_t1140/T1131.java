package com.github.morningwn.t1001_t1500.t1101_t1200.t1131_t1140;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/maximum-of-absolute-value-expression/">1131. 绝对值表达式的最大值</a>
 *
 * @author morningwn
 * @date
 */
public class T1131 {

    @Test
    public void test() {

//        int[] arr1 = {1,2,3,4};
//        int[] arr2 = {-1,4,5,6};

        int[] arr1 = {1, -2, -5, 0, 10};
        int[] arr2 = {0, -2, -1, -7, -4};
        Out.println(maxAbsValExpr(arr1, arr2));
    }

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int[] num = {1, -1};
        int ans = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                for (int k = 0; k < num.length; k++) {
                    int max = -1000000, min = 1000000;
                    for (int i1 = 0; i1 < arr1.length; i1++) {
                        max = Math.max(max, arr1[i1] * num[i] + arr2[i1] * num[j] + i1 * num[k]);
                        min = Math.min(min, arr1[i1] * num[i] + arr2[i1] * num[j] + i1 * num[k]);
                    }
                    ans = Math.max(ans, max - min);
                }
            }
        }
        return ans;
    }

    public int maxAbsValExpr1(int[] arr1, int[] arr2) {

        int reault = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = arr1.length - 1; j > i; j--) {
                int tmp = Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j);
                if (tmp > reault) {
                    reault = tmp;
                }
            }
        }

        return reault;
    }

    public int abs(int a, int b, int c, int d, int i, int j) {
        int sum1 = a - b + c - d;
        int sum2 = a - b - c + d;
        int sum3 = -a + b + c - d;
        int sum4 = -a + b - c + d;

        int sum = Math.max(Math.max(sum1, sum2), Math.max(sum3, sum4));

        int res1 = sum + i - j;
        int res2 = sum - i + j;
        int res3 = -sum + i - j;
        int res4 = -sum - i + j;
        return Math.max(Math.max(res1, res2), Math.max(res3, res4));
    }

}
