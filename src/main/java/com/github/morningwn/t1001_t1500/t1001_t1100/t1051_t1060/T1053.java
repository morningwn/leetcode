package com.github.morningwn.t1001_t1500.t1001_t1100.t1051_t1060;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/previous-permutation-with-one-swap/">1053. 交换一次的先前排列</a>
 *
 * @author morningwn
 * @create in 2023/4/3 13:17
 */
public class T1053 {

    @Test
    public void test() {
//        int[] arr = {3,2,1};
//        int[] arr = {1, 1, 5};
        int[] arr = {9, 9, 4, 6, 7};

        int[] ints = prevPermOpt1(arr);
        Out.print(ints);
    }

    public int[] prevPermOpt1(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            int lessThanOne = findLessThanOne(arr, arr[i], i + 1);
            if (lessThanOne != -1) {
                int tmp = arr[i];
                arr[i] = arr[lessThanOne];
                arr[lessThanOne] = tmp;
                return arr;
            }
        }

        return arr;
    }

    private int findLessThanOne(int[] arr, int target, int start) {
        int lessThanOneIndex = -1;
        int lessThanOneNum = 0;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] < target) {
                if (arr[i] > lessThanOneNum) {
                    lessThanOneNum = arr[i];
                    lessThanOneIndex = i;
                }
            }
        }
        return lessThanOneIndex;
    }
}
