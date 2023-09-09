//
// Created by morningwn on 23-3-5.
// https://leetcode.cn/problems/maximum-product-of-three-numbers/
//
#include <vector>

using namespace std;

int maximumProduct(vector<int> &nums) {
    int max1 = -1000;
    int max2 = -1000;
    int max3 = -1000;

    int min1 = 1000;
    int min2 = 1000;

    for (int num: nums) {
        if (num > max1) {
            max3 = max2;
            max2 = max1;
            max1 = num;
        } else if (num > max2) {
            max3 = max2;
            max2 = num;
        } else if (num > max3) {
            max3 = num;
        }
        if (num < min1) {
            min2 = min1;
            min1 = num;
        } else if (num < min2) {
            min2 = num;
        }
    }
    return max(max1 * max2 * max3, min1 * min2 * max1);
}

int main () {
    return 0;
}