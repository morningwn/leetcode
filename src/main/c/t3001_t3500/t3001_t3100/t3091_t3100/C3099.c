//
// Created by morningwn on 2024/7/3.
//
// 3099. 哈沙德数
// https://leetcode.cn/problems/harshad-number/description/

#include <stdio.h>
#include <stdlib.h>

int sumOfTheDigitsOfHarshadNumber(int x) {
    int tmpx = x;
    int sum = 0;
    while (tmpx > 0) {
        sum += tmpx % 10;
        tmpx /= 10;
    }
    return x % sum == 0 ? sum : -1;
}

int main() {
    printf("res %d", sumOfTheDigitsOfHarshadNumber(18));
    return 0;
}