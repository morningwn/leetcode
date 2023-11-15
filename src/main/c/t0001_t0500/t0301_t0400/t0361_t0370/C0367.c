/**
 * 367. 有效的完全平方数
 * <link>https://leetcode-cn.com/problems/valid-perfect-square/</link>
 */
#include <stdio.h>
#include <stdbool.h>

bool isPerfectSquare(int num) {
    unsigned int left = 0;
    unsigned int right = num;
    unsigned int middle = 0;
    unsigned long square = 0;

    while (left <= right) {

        middle = (left + right) / 2;
        square = (unsigned long) middle * middle;
        if (square > num) {
            right = middle - 1;
        } else if (square < num) {
            left = middle + 1;
        } else {
            return true;
        }

    }

    return false;
}

int main() {

    int num = 2147395600;

    printf("res: %d", isPerfectSquare(num));

    return 0;
}
