/**
 * 476. 数字的补数
 */

#include <stdio.h>

int findComplement(int num) {

    unsigned int res = 0;
    unsigned int bit = 1;

    while (num > 0) {
        if ((num & bit) == 0) {
            res |= bit;
        } else {
            num -= bit;
        }

        bit <<= 1;
    }

    return res;
}

int main() {
    int num = 2147483647;

    printf("%d", findComplement(num));

    return 0;
}
