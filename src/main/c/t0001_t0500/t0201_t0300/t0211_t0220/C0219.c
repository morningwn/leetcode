/**
//  * <a href="https://leetcode-cn.com/problems/contains-duplicate-ii/">219. 存在重复元素 II</a>
 */
#include <stdio.h>
#include <stdbool.h>
#include "uthash.h"

typedef struct hashTable {
    int key;
    int val;
    UT_hash_handle hh;
} hashTable;

bool containsNearbyDuplicate(int *nums, int numsSize, int k) {
    hashTable *map = NULL;

    for (int i = 0; i < numsSize; i++) {
        hashTable *tmp = NULL;
        HASH_FIND_INT(map, &nums[i], tmp);
        if (tmp == NULL) {
            tmp = (hashTable *) malloc(sizeof(hashTable));
            tmp->key = nums[i];
            tmp->val = i;
            HASH_ADD_INT(map, key, tmp);
        } else {
            if (i - tmp->val <= k) {
                return true;
            } else {
                tmp->val = i;
            }
        }
    }

    return false;
}

int main() {

    int nums[] = {1, 2, 3, 1};
    int numsSize = 4;
    int k = 3;

    printf("res %d", containsNearbyDuplicate(nums, numsSize, k));
    return 0;
}
