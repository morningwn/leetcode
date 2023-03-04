//
// Created by morningwn on 23-3-4.
// https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/
//
#include <vector>
#include <cstdlib>

using namespace std;

int countTriplets(vector<int> &nums) {
    int *counts = (int *) ::calloc(1 << 16, sizeof(int));

    for (const auto &x: nums) {
        for (const auto &y: nums) {
            counts[x & y]++;
        }
    }
    int triplets = 0;
    for (const auto &num: nums) {
        int target = num ^ 0xffff;
        int tmp = target;
        while (tmp) {
            triplets += counts[tmp];
            tmp = target & (tmp - 1);
        }
        triplets += counts[0];
    }

    ::free(counts);
    return triplets;
}

int main() {
    return 0;
}