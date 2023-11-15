//
// Created by morningwn on 23-3-4.
// https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/
//
#include <stdlib.h>

int countTriplets(int *nums, int numsSize) {
    int *counts = (int *) calloc(1 << 16, sizeof(int));
    for (int i = 0; i < numsSize; ++i) {
        for (int j = 0; j < numsSize; ++j) {
            counts[nums[i] & nums[j]]++;
        }
    }

    int triplets = 0;
    for (int i = 0; i < numsSize; ++i) {
        int target = nums[i] ^ 0xffff;
        int tmp = target;
        while (tmp != 0) {
            triplets += counts[tmp];
            tmp = target & (tmp - 1);
        }
        triplets += counts[0];
    }

    free(counts);
    return triplets;
}

int main() {
    return 0;
}