/**
 * 162. 寻找峰值
 */

#include <stdio.h>

int findPeakElement(int *nums, int numsSize) {
    int l = 0;
    int r = numsSize - 1;

    while (l <= r) {
        int m = (l + r) / 2;

        if (nums[m] > nums[(m + 1) % numsSize]) {
            if (nums[m] > nums[(numsSize + m - 1) % numsSize]) {
                return m;
            } else {
                r = m - 1;
            }
        } else {
            l = m + 1;
        }
    }

    return 0;
}

int main() {
    printf("Hello, World!\n");
    int nums[] = {1, 2, 3, 4, 5, 6, 1};

    printf("%d", findPeakElement(nums, 7));

    return 0;
}

