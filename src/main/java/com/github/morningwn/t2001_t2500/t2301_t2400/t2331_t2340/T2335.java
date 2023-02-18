package com.github.morningwn.t2001_t2500.t2301_t2400.t2331_t2340;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/">2335. 装满杯子需要的最短总时长</a>
 *
 * @author morningwn
 * @create in 2023/2/11 23:29
 */
public class T2335 {

    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[1] + amount[0]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }
}
