//
// Created by morningwn on 23-3-9.
// https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
//
#include <string>

using namespace std;

int minimumRecolors(string blocks, int k) {
    int minCount = k;
    int count = 0;
    for (int i = 0; i < blocks.length(); ++i) {
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

int main () {
    return 0;
}