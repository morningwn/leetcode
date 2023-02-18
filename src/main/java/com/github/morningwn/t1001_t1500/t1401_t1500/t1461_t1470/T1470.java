package com.github.morningwn.t1001_t1500.t1401_t1500.t1461_t1470;

/**
 * @author morningwn
 * @description: 重新排列数组
 * @date Created in 2020/7/20 17:50
 * @version: 1.0
 */
public class T1470 {

    public int[] shuffle(int[] nums, int n) {

        int[] res = new int[n * 2];
        int i = 0;
        int j = n;
        int k = 0;
        while (j < 2 * n) {
            res[k++] = nums[i++];
            res[k++] = nums[j++];
        }

        return res;
    }
}
