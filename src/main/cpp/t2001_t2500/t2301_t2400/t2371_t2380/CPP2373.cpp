//
// Created by morningwn on 23-3-1.
//<a href="https://leetcode.cn/problems/largest-local-values-in-a-matrix/">2373. 矩阵中的局部最大值</a>
//
#include <vector>
#include <iostream>

using namespace std;

vector<vector<int>> largestLocal(vector<vector<int>> &grid) {
    int n = grid.size();
    vector<vector<int>> maxLocals(n - 2, vector<int>(n - 2, 0));

    for (int i = 0; i < n - 2; ++i) {
        for (int j = 0; j < n - 2; ++j) {
            for (int k = i; k < i + 3; ++k) {
                for (int l = j; l < j + 3; ++l) {
                    maxLocals[i][j] = max(maxLocals[i][j], grid[k][l]);
                }
            }
        }
    }
    return maxLocals;
}

int main() {
    cout << "hello word" << endl;
    return 0;
}