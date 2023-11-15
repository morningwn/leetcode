/**
 * 66. 加一
 * https://leetcode-cn.com/problems/plus-one/
 */
#include <stdio.h>
#include <stdlib.h>

int *plusOne(int *digits, int digitsSize, int *returnSize) {
    int carry = 1;
    int tmp = 0;

    for (int i = digitsSize - 1; i >= 0; i--) {
        tmp = digits[i];
        digits[i] = (tmp + carry) % 10;
        carry = (tmp + carry) / 10;
    }

    if (carry != 0) {
        *returnSize = digitsSize + 1;
        digits = (int *) realloc(digits, *returnSize * sizeof(int));
        digits[0] = 1;
        digits[*returnSize - 1] = 0;

        return digits;
    } else {
        *returnSize = digitsSize;
        return digits;
    }
}

int main() {

    int nums[] = {9, 9, 9, 9};
    int returnSize = 4;

    int *res = plusOne(nums, 4, &returnSize);

    printf("returnSize: %d \n", returnSize);

    for (int i = 0; i < returnSize; ++i) {
        printf("%d, ", res[i]);
    }

    return 0;
}
