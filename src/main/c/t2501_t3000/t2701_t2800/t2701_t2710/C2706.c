/**
 * 2706. 购买两块巧克力
 * https://leetcode.cn/problems/buy-two-chocolates/
 */

#include <stdio.h>
#include <stdlib.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))
#define MIN(a, b) ((a) < (b) ? (a) : (b))

int buyChoco(int* prices, int pricesSize, int money) {
    int min1 = MIN(prices[0], prices[1]);
    int min2 = MAX(prices[0], prices[1]);

    for (int i = 2; i < pricesSize; ++i) {
        if (prices[i] < min1) {
            min2 = min1;
            min1 = prices[i];
        } else if (prices[i] < min2) {
            min2 = prices[i];
        }
    }
    if (money >= min1 + min2) {
        return money - min1 - min2;
    } else {
        return money;
    }
}

int main() {
    return 0;
}
