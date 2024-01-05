/**
 * 1944. 队列中可以看到的人数
 * https://leetcode.cn/problems/number-of-visible-people-in-a-queue/
 */

#include <stdio.h>
#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* canSeePersonsCount(int* heights, int heightsSize, int* returnSize) {
    int* stack = calloc(heightsSize, sizeof(int));
    int* seeCounts = calloc(heightsSize, sizeof(int));
    *returnSize = heightsSize;
    int stackSize = 0;

    for (int i = heightsSize - 1; i >= 0; --i) {
        while (stackSize > 0 && stack[stackSize - 1] <= heights[i]) {
            seeCounts[i]++;
            stackSize--;
        }

        if (stackSize > 0) {
            seeCounts[i]++;
        }
        stack[stackSize++] = heights[i];
    }
    free(stack);
    return seeCounts;
}


int main() {
    return 0;
}
