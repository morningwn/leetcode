//
// Created by morningwn on 23-3-9.
// https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
//
#include <string.h>
#include <stdio.h>

int minimumRecolors(char *blocks, int k) {
    int length = strlen(blocks);
    int minCount = k;
    int count = 0;
    for (int i = 0; i < length; ++i) {
        if (blocks[i] == 'W') {
            count++;
        }
        if (i >= k && blocks[i - k] == 'W') {
            count--;
        }
        if (i >= k - 1 && count < minCount) {
            minCount = count;
        }
    }
    return minCount;
}

int main() {
    char *blocks = "WBBWWBBWBW";
    int k = 7;

    int min = minimumRecolors(blocks, k);
    printf("min: %d", min);
    return 0;
}