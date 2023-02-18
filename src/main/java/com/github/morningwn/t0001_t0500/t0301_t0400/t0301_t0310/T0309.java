package com.github.morningwn.t0001_t0500.t0301_t0400.t0301_t0310;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author morningwn
 * @date Created in 2020/7/10 9:17
 */
public class T0309 {

    @Test
    public void test() {
        int[] prices = {1, 5, 6, 3, 0, 4, 2, 5, 4, 9, 2};
        Out.println(maxProfit(prices));
    }

    /**
     * @author morningwn
     * @date 2020/7/10 10:21
     * @description: 动态规划，时间复杂度优化
     * @param: prices
     * @return: int
     */
    public int maxProfit(int[] prices) {
        int[] res = new int[prices.length + 1];


        for (int i = 1; i < res.length; i++) {
            res[i] = prices[i - 1] - prices[0];
            for (int k = 0; k < i - 1; k++) {
                res[i] = Math.max(res[i], res[k] + prices[i - 1] - prices[k + 1]);
            }
            res[i] = Math.max(res[i], res[i - 1]);
        }

        return res[prices.length];
    }


    /**
     * @author morningwn
     * @date 2020/7/10 10:10
     * @description: 动态规划算法，超时
     * @param: prices
     * @return: int
     */
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[][] res = new int[len + 1][len + 1];

        for (int l = len; l > 0; l--) {
            for (int i = 1; i <= l; i++) {
                int j = i + len - l;

                res[i][j] = prices[j - 1] - prices[i - 1];
                for (int k = i; k < j; k++) {
                    if (res[i][k - 1] + res[k + 1][j] > res[i][j]) {
                        res[i][j] = res[i][k - 1] + res[k + 1][j];
                    }
                }

                if (res[i][j - 1] > res[i][j]) {
                    res[i][j] = res[i][j - 1];
                }
            }
        }

        for (int[] tmp : res) {
            Out.println(Arrays.toString(tmp));
        }
        return res[1][len];
    }

}
