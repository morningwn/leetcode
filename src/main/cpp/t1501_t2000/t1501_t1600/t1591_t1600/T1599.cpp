//
// Created by morningwn on 23-3-5.
// https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/
//
#include <vector>

using namespace std;

int minOperationsMaxProfit(vector<int> &customers, int boardingCost, int runningCost) {
    int maxProfit = -1;
    int minOperation = 0;
    int profit = 0;
    int operation = 0;
    int waitCustomer = 0;
    for (const auto &customer: customers) {
        if (waitCustomer + customer >= 4) {
            profit += 4 * boardingCost - runningCost;
            waitCustomer += customer - 4;
        } else {
            profit += (waitCustomer + customer) * boardingCost - runningCost;
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