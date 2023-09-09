//
// Created by morningwn on 23-3-8.
// https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))

int maxValue(int **grid, int gridSize, int *gridColSize) {
    int m = gridSize;
    int n = gridColSize[0];
    int valueCount[m + 1][n + 1];
    memset(valueCount, 0, sizeof(valueCount));

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            valueCount[i + 1][j + 1] = MAX(valueCount[i][j + 1], valueCount[i + 1][j]) + grid[i][j];
        }
    }
    return valueCount[m][n];
}

int main() {
    return 0;
}