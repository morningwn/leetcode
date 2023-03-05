package com.github.morningwn.t1501_t2000.t1501_t1600.t1591_t1600;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/">1599. 经营摩天轮的最大利润</a>
 *
 * @author morningwn
 * @date Created in 2023/3/5 12:57
 */
public class T1599 {

    @Test
    public void test() {
        int[] customers = {8, 3};
        int boardingCost = 5;
        int runningCost = 6;
        int operationsMaxProfit = minOperationsMaxProfit(customers, boardingCost, runningCost);
        Out.println(operationsMaxProfit);
    }

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int maxProfit = Integer.MIN_VALUE;
        int minOperation = Integer.MAX_VALUE;
        int profit = 0;
        int waitCustomer = 0;
        int operation = 0;

        for (int i = 0; i < customers.length; i++) {
            if (waitCustomer + customers[i] >= 4) {
                waitCustomer = waitCustomer + customers[i] - 4;
                profit += 4 * boardingCost - runningCost;
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

        while (waitCustomer > 0) {
            if (waitCustomer >= 4) {
                waitCustomer -= 4;
                profit += 4 * boardingCost - runningCost;
            } else {
                profit += waitCustomer * boardingCost - runningCost;
                waitCustomer = 0;
            }
            operation++;
            if (profit > maxProfit) {
                maxProfit = profit;
                minOperation = operation;
            }
        }

        return maxProfit > 0 ? minOperation : -1;
    }
}
