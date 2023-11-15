//
// Created by morningwn on 23-3-1.
//<a href="https://leetcode.cn/problems/largest-local-values-in-a-matrix/">2373. 矩阵中的局部最大值</a>
//
#include <stdio.h>
#include <stdlib.h>

int **largestLocal(int **grid, int gridSize, int *gridColSize, int *returnSize, int **returnColumnSizes) {
    int **maxLocals = (int **) malloc(sizeof(int *) * gridSize - 2);
    for (int i = 0; i < gridSize - 2; ++i) {
        maxLocals[i] = (int *) calloc(gridSize - 2, sizeof(int));
    }

    for (int i = 0; i < gridSize - 2; ++i) {
        for (int j = 0; j < gridSize - 2; ++j) {
            int maxLocal = 0;

            for (int k = i; k < i + 3; ++k) {
                for (int l = j; l < j + 3; ++l) {
                    if (grid[k][l] > maxLocal) {
                        maxLocal = grid[k][l];
                    }
                }
            }
            maxLocals[i][j] = maxLocal;
        }
    }
    *returnSize = gridSize - 2;
    *returnColumnSizes = (int *) calloc(gridSize - 2, sizeof(int));
    for (int i = 0; i < gridSize - 2; i++) {
        (*returnColumnSizes)[i] = gridSize - 2;
    }
    return maxLocals;
}

int main() {
    printf("res");
    return 0;
}