package com.github.morningwn.t1001_t1500.t1001_t1100.t1011_t1020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/partition-array-into-three-parts-with-equal-sum/">1013. 将数组分成和相等的三个部分</a>
 *
 * @author morningwn
 * @create 2022/8/9 17:20
 */
public class T1013 {

    @Test
    public void test() {
        int[] arr = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        Out.println(canThreePartsEqualSum(arr));
    }

    public boolean canThreePartsEqualSum(int[] arr) {

        int index = 0;
        int sum = 0;
        int target = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return false;
        }
        target = sum / 3;
        int tmp = 0;
        while (index < arr.length) {
            tmp += arr[index++];
            if (tmp == target) {
                break;
            }
        }

        tmp = 0;
        while (index < arr.length) {
            tmp += arr[index++];
            if (tmp == target) {
                break;
            }
        }

        return index < arr.length;
    }
}
