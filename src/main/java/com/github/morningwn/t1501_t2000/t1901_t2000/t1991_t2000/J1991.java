package com.github.morningwn.t1501_t2000.t1901_t2000.t1991_t2000;

/**
 * <a href="https://leetcode.cn/problems/find-the-middle-index-in-array/description/">1991. 找到数组的中间位置</a>
 *
 * @author morningwn
 * @date 2024/07/08 下午4:19
 */
public class J1991 {
    public int findMiddleIndex(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}