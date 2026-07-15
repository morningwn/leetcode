package com.github.morningwn.t1001_t1500.t1401_t1500.t1461_t1470;

/**
 * <a href="https://leetcode.cn/problems/shuffle-the-array/">1470. 重新排列数组</a>
 *
 * @author morningwn
 * @date 2020-07-20 17:52:52
 */
public class J1470 {

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
