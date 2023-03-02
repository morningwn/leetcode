//
// Created by morningwn on 23-3-2.
// https://leetcode.cn/problems/bianry-number-to-string-lcci/
//
#include <stdlib.h>
#include <stdio.h>

char *printBin(double num) {
    char *bin = calloc( 33, sizeof(char));
    int position = 2;
    bin[0] = '0';
    bin[1] = '.';
    while (position <= 32 && num != 0) {
        num *= 2;
        int digit = (int) num;
        bin[position++] = digit + '0';
        num -= digit;
    }
    if (position > 32) {
        free(bin);
        return "ERROR";
    }
    return bin;
}

int main() {
    double num = 0.625;
    char *bin = printBin(num);
    printf("res: %s\n", bin);
    printf("t : %d", '\0');
    return 0;
}