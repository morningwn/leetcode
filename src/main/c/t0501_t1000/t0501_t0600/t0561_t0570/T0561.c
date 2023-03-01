/**
 * <a href="https://leetcode-cn.com/problems/array-partition-i/">561. 数组拆分 I</a>
 */
#include <stdio.h>

int arrayPairSum(int *nums, int numsSize) {
    int counter[20001] = {0};

    for (int i = 0; i < numsSize; i++) {
        ++counter[nums[i] + 10000];
    }

    int res = 0;
    int pre = 0;
    int cur = 0;

    while (cur < 20001) {
        if (counter[cur] != 0) {
            if (counter[pre] % 2 == 0) {
                res += counter[cur] / 2 * (cur - 10000);
            } else {
                res += pre - 10000;
                res += --counter[cur] / 2 * (cur - 10000);
            }
            pre = cur;
        }

        ++cur;
    }

    return res;
}

int main() {
    int nums[] = {1, 2, 3, 4};

    int res = arrayPairSum(nums, 4);

    printf("res: %d", res);

    return 0;
}
