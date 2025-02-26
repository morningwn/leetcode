package com.github.morningwn.t1001_t1500.t1401_t1500.t1471_t1480;

/**
 * <a href="https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/">1475. 商品折扣后的最终价格</a>
 *
 * @author morningwn
 * @create in 2025/02/16 14:01
 */
public class J1475 {

    public int[] finalPrices(int[] prices) {
        int[] finalPrices = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            finalPrices[i] = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    finalPrices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return finalPrices;
    }
}
