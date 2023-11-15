//
// Created by morningwn on 23-3-5.
// https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/
//
int minOperationsMaxProfit(int *customers, int customersSize, int boardingCost, int runningCost) {
    int maxProfit = -1;
    int minOperation = 0;
    int profit = 0;
    int operation = 0;
    int waitCustomer = 0;
    for (int i = 0; i < customersSize; ++i) {
        if (waitCustomer + customers[i] >= 4) {
            profit += 4 * boardingCost - runningCost;
            waitCustomer += customers[i] - 4;
        } else {
            profit += (waitCustomer + customers[i]) * boardingCost - runningCost;
            waitCustomer = 0;
        }
        operation++;
        if (profit > maxProfit) {
            maxProfit = profit;
            minOperation = operation;
        }
    }

    if (waitCustomer >= 4) {
        if (4 * boardingCost > runningCost) {
            profit += (4 * boardingCost - runningCost) * waitCustomer / 4;
            operation += waitCustomer / 4;
            waitCustomer %= 4;
            maxProfit = profit;
            minOperation = operation;
        } else {
            return -1;
        }
    }
    if (waitCustomer && (waitCustomer * boardingCost - runningCost) > 0) {
        profit += waitCustomer * boardingCost - runningCost;
        operation++;
        waitCustomer = 0;
        maxProfit = profit;
        minOperation = operation;
    }
    return maxProfit > 0 ? minOperation : -1;
}

int main () {
    return 0;
}