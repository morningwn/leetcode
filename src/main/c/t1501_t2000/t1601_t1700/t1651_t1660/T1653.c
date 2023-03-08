//
// Created by morningwn on 23-3-8.
// https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
//
#include <string.h>
#include <stdlib.h>
#include <limits.h>

#define MIN(a, b) ((a < b ) ? a : b)

int minimumDeletions(char *s) {
    int length = strlen(s);
    int *countA = calloc(sizeof(int), length);
    int *countB = calloc(sizeof(int), length);
    int minDeletions = INT_MAX;

    countA[length - 1] = s[length - 1] == 'a' ? 1 : 0;
    countB[0] = s[0] == 'b' ? 1 : 0;
    for (int i = 1, j = length - 2; i < length; ++i, --j) {
        countA[j] = countA[j + 1] + (s[j] == 'a' ? 1 : 0);
        countB[i] = countB[i - 1] + (s[i] == 'b' ? 1 : 0);
    }
    for (int i = 0; i < length; ++i) {
        minDeletions = MIN(minDeletions, countA[i] + countB[i] - 1);
    }

    free(countA);
    free(countB);
    return minDeletions;
}