/**
 * 1005. K 次取反后最大化的数组和
 * <link>https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/</link>
 */
#include <stdio.h>

int largestSumAfterKNegations(int *nums, int numsSize, int k) {

    int counts[201] = {0};

    for (int i = 0; i < numsSize; ++i) {
        counts[nums[i] + 100] += 1;
    }

    for (int i = 0; i < 100 && k > 0; ++i) {
        if (counts[i] <= k) {
            counts[200 - i] += counts[i];
            k -= counts[i];
            counts[i] = 0;
        } else {
            counts[200 - i] += k;
            counts[i] -= k;
            k = 0;
        }
    }

    int index = 101;
    int res = 0;
    if (k % 2 == 1 && counts[100] == 0) {
        while (counts[index] == 0) {
            index++;
        }
        counts[index] -= 1;
        res -= index - 100;
    } else {
        index = 0;
    }

    while (index < 201) {
        res += counts[index] * (index - 100);
        index++;
    }

    return res;
}

int main() {

    int nums[] = {-1, 2, 3};
    int numsSize = 3;
    int k = 1;

    printf("res: %i", largestSumAfterKNegations(nums, numsSize, k));

    return 0;
}