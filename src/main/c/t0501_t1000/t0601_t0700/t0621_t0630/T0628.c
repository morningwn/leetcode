//
// Created by morningwn on 23-3-5.
// https://leetcode.cn/problems/maximum-product-of-three-numbers/
//
#define MAX(a, b) a > b ? a : b;

int maximumProduct(int* nums, int numsSize){
    int max1 = -1000;
    int max2 = -1000;
    int max3 = -1000;

    int min1 = 1000;
    int min2 = 1000;

    for (int i = 0; i < numsSize; i++) {
        if (nums[i] > max1) {
            max3 = max2;
            max2 = max1;
            max1 = nums[i];
        } else if (nums[i] > max2) {
            max3 = max2;
            max2 = nums[i];
        } else if (nums[i] > max3) {
            max3 = nums[i];
        }
        if (nums[i] < min1) {
            min2 = min1;
            min1 = nums[i];
        } else if (nums[i] < min2) {
            min2 = nums[i];
        }
    }

    return MAX(max1 * max2 * max3, min1 * min2 * max1);
}