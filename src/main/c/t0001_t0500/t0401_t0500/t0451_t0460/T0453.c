/**
 * 453. 最小操作次数使数组元素相等
 * <link>https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/</link>
 */
#include <stdio.h>

int minMoves(int *nums, int numsSize) {
    int min = 1000000000;
    int sum = 0;

    for (int i = 0; i < numsSize; ++i) {
        sum += nums[i];

        if (nums[i] < min) {
            min = nums[i];
        }
    }

    return sum - min * numsSize;

}

int main() {
    return 0;
}
