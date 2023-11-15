//
// 2656. K 个元素的最大和
// https://leetcode.cn/problems/maximum-sum-with-exactly-k-elements/
// Created by Mac on 2023/11/15.

int maximizeSum(int *nums, int numsSize, int k) {
    int maxNum = nums[0];
    for (int i = 0; i < numsSize; ++i) {
        if (nums[i] > maxNum) {
            maxNum = nums[i];
        }
    }
    return maxNum * k + (((k - 1) * k) / 2);
}