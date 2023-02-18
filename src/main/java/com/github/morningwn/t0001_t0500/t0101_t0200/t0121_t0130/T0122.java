package com.github.morningwn.t0001_t0500.t0101_t0200.t0121_t0130;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T0122 {

    @Test
    public void test() {
//        int[] prices = { 7,6,4,3,1};         //0
//        int[] prices = { 1,2,3,4,5};         //4
        int[] prices = {7, 1, 5, 3, 6, 4};         //7

//        int[] prices = { 0,6,4,3,1,9 };         //14
        Out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        //处理特殊情况
        if (prices.length == 0) {
            return 0;
        }

        int profit = 0;             //用来存储总的利润
        int minPrice = prices[0];   //在交易后的几天里面，最低的价格


        //遍历整个数组，只要价格比前一次交易后的几天里面的最低价高就进行一次交易
        for (int i = 1; i < prices.length; i++) {

            if (minPrice < prices[i]) {
                profit += prices[i] - minPrice;
                minPrice = prices[i];
            } else {
                minPrice = prices[i];
            }

        }

        return profit;
    }

}
