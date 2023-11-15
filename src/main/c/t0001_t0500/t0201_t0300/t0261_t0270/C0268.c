/**
 * 268. 丢失的数字
 * <link>https://leetcode-cn.com/problems/missing-number/</link>
 */
#include <stdio.h>

int missingNumber(int *nums, int numsSize) {
    int res = numsSize;

    for (int i = 0; i < numsSize; ++i) {
        res ^= (i ^ nums[i]);
    }

    return res;
}

int main() {

    int nums[] = {3, 0, 1};
    int numsSize = 3;

    printf("res: %d", missingNumber(nums, numsSize));

    return 0;
}
