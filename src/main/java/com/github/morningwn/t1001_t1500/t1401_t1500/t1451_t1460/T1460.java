package com.github.morningwn.t1001_t1500.t1401_t1500.t1451_t1460;

/**
 * <a href="https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/">1460. 通过翻转子数组使两个数组相等</a>
 *
 * @author morningwn
 * @create in 2022/8/24 15:42
 */
public class T1460 {

    public boolean canBeEqual(int[] target, int[] arr) {
        int[] counts = new int[1001];

        for (int num : target) {
            counts[num]++;
        }

        for (int num : arr) {
            counts[num]--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
