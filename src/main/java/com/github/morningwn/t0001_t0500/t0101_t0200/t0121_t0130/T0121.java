package com.github.morningwn.t0001_t0500.t0101_t0200.t0121_t0130;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T0121 {

    @Test
    public void test() {


//        int[] prices = { 7,1,5,3,6,4 };         //5
//        int[] prices = { 7,6,4,3,1 };         //0
        int[] prices = {0, 6, 4, 3, 1, 9};         //8

        Out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int minCost = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {

            if (max < prices[i] - minCost) {
                max = prices[i] - minCost;
            }
            if (minCost > prices[i]) {
                minCost = prices[i];
            }
        }

        return max;
    }

}
