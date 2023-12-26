/**
 * 1313. 解压缩编码列表
 * https://leetcode.cn/problems/decompress-run-length-encoded-list/
 */

#include <stdio.h>
#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* decompressRLElist(int* nums, int numsSize, int* returnSize) {
    int count = 0;
    for (int i = 0; i < numsSize; i += 2) {
        count += nums[i];
    }
    *returnSize = count;

    int* res = calloc(count, sizeof(int));

    for (int i = 0, index = 0; i < numsSize; i+=2) {
        for (int j = 0; j < nums[i]; ++j) {
            res[index++] = nums[i + 1];
        }
    }
    return res;
}

int main() {
    return 0;
}
