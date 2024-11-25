package com.github.morningwn.t0501_t1000.t0701_t0800.t0741_t0750;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a hre="https://leetcode.cn/problems/min-cost-climbing-stairs/">746. 使用最小花费爬楼梯</a>
 *
 * @author morningwn
 * @date Created in 2020/5/24 17:46
 */
public class J0746 {

    @Test
    public void test() {
//        int[] cost = {10, 15, 20};      //15
//        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost = {302, 541, 997, 214, 429, 961, 648, 774, 244, 684, 218, 49, 729, 990, 521, 948, 317, 847, 76, 566, 415, 874, 399};
        Out.println(minCostClimbingStairs(cost));
        Out.println(minCostClimbingStairs1(cost));

    }

    /**
     * 非递归， f[i] = cost[i] + min(f[i+1], f[i+2]).
     */
    public int minCostClimbingStairs(int[] cost) {

        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 0; i < cost.length; i++) {
            c = Math.min(a + cost[i], b + cost[i]);
            a = b;
            b = c;
        }

        return Math.min(a, b);
    }

    /**
     * 递归
     */
    public int minCostClimbingStairs1(int[] cost) {
        return Math.min(helper(cost, 0), helper(cost, 1));
    }

    public int helper(int[] cost, int index) {
        if (index < cost.length) {
            return cost[index] + Math.min(helper(cost, index + 1), helper(cost, index + 2));
        } else {
            return 0;
        }
    }

}
