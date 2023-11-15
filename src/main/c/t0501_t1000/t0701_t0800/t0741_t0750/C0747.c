/**
 * <a href="https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/">747. 至少是其他数字两倍的最大数</a>
 */
#include <stdio.h>

int dominantIndex(int *nums, int numsSize) {
    int maxNum = 0;
    int maxIndex = 0;

    for (int i = 0; i < numsSize; i++) {
        if (maxNum < nums[i]) {
            maxNum = nums[i];
            maxIndex = i;
        }

    }

    for (int i = 0; i < numsSize; i++) {
        if (i != maxIndex && nums[i] * 2 > maxNum) {
            return -1;
        }

    }

    return maxIndex;
}

int main() {
    int nums[] = {2, 2, 3, 4, 5, 6, 7, 8, 87, 5, 3, 4, 3, 2, 3, 2};
    int numsSize = 16;

    printf("res: %d", dominantIndex(nums, numsSize));

    return 0;
}