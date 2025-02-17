package com.github.morningwn.t1001_t1500.t1201_t1300.t1281_t1290;

/**
 * <a href="https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array/">1287. 有序数组中出现次数超过25%的元素</a>
 *
 * @author morningwn
 * @date 2025-02-17 17:31:49
 */
public class J1287 {

    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        if (length == 1) {
            return arr[0];
        }
        int c = 1;
        for (int i = 1; i < length; i++) {
            if (arr[i - 1] == arr[i]) {
                c++;
                if (length / 4.0 <= c) {
                    return arr[i];
                }
            } else {
                c = 1;
            }
        }

        return -1;
    }

}