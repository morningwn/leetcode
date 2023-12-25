/**
 * 1276. 不浪费原料的汉堡制作方案
 * https://leetcode.cn/problems/number-of-burgers-with-no-waste-of-ingredients/
 */

#include <stdio.h>
#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* numOfBurgers(int tomatoSlices, int cheeseSlices, int* returnSize) {
    int x = (tomatoSlices - 2 * cheeseSlices) / 2;
    int y = cheeseSlices - x;
    if (tomatoSlices % 2 != 0 || x < 0 || y < 0) {
        *returnSize = 0;
        return NULL;
    }
    int* res = calloc(2, sizeof(int));
    *returnSize = 2;
    res[0] = x;
    res[1] = y;
    return res;
}

int main() {
    return 0;
}
