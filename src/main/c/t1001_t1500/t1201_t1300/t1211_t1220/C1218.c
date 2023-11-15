/**
 * 1218. 最长定差子序列
 * <link>https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/</link>
 */
#include <stdio.h>

int longestSubsequence(int *arr, int arrSize, int difference) {

    int counts[40001] = {0};
    int res = 0;

    for (int i = 0; i < arrSize; ++i) {
        int tmp = counts[arr[i] + 20000 - difference] + 1;
        counts[arr[i] + 20000] = tmp;
        if (res < tmp) {
            res = tmp;
        }
    }

    return res;
}

int main() {

    int arr[] = {1, 2, 3, 4};
    int arrSize = 4;
    int difference = 1;

    printf("res: %d", longestSubsequence(arr, arrSize, difference));

    return 0;
}