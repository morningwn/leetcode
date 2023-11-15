//
// Created by morningwn on 23-3-8.
// https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
//
#include <vector>
#include <cstring>

using namespace std;

int maxValue(vector<vector<int>> &grid) {
    int m = grid.size();
    int n = grid[0].size();
    int valueCount[m + 1][n + 1];
    memset(valueCount, 0, sizeof(valueCount));

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            valueCount[i + 1][j + 1] = max(valueCount[i][j + 1], valueCount[i + 1][j]) + grid[i][j];
        }
    }
    return valueCount[m][n];
}

int main () {
    return 0;
}