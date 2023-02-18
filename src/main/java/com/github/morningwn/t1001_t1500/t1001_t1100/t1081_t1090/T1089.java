package com.github.morningwn.t1001_t1500.t1001_t1100.t1081_t1090;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/duplicate-zeros/">1089. 复写零</a>
 *
 * @author moringwn
 * @create in 2022/6/17 16:03
 */
public class T1089 {

    @Test
    public void test() {
//        int[] arr = {1, 0, 0, 1};
//        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
//        int[] arr = {1, 0, 0, 2, 3, 0, 0, 4};
//        int[] arr = {1, 0, 0, 0, 0, 2, 3, 0, 0, 4};
        int[] arr = {0, 1, 7, 6, 0, 2, 0, 7};

        duplicateZeros(arr);

        Out.println(Arrays.toString(arr));
    }

    public void duplicateZeros(int[] arr) {
        int i = 0;
        int j = 0;
        int length = arr.length;

        while (j < length) {
            if (arr[i] == 0) {
                j++;
            }
            i++;
            j++;
        }
        i--;
        j--;
        while (i >= 0) {
            if (j < length) {
                arr[j] = arr[i];
            }
            if (arr[i] == 0 && --j >= 0) {
                arr[j] = 0;
            }
            j--;
            i--;
        }
    }

    public void duplicateZeros1(int[] arr) {
        int length = arr.length;

        int[] copy = Arrays.copyOf(arr, length);
        int i = 0;
        int j = 0;

        while (j < length) {
            if (copy[i] != 0) {
                arr[j] = copy[i];
                i++;
                j++;
            } else {
                arr[j] = copy[i];
                if (j + 1 < length) {
                    arr[j + 1] = 0;
                }
                j += 2;
                i++;
            }
        }
    }
}
