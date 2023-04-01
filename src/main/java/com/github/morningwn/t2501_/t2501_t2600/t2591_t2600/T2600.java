package com.github.morningwn.t2501_.t2501_t2600.t2591_t2600;

/**
 * <a href="https://leetcode.cn/problems/k-items-with-the-maximum-sum/">2600. K 件物品的最大和</a>
 *
 * @author morningwn
 * @create in 2023/4/1 09:50
 */
public class T2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k) {
            return k;
        }
        if (numOnes + numZeros >= k) {
            return numOnes;
        }

        return numOnes - (k - numOnes - numZeros);
    }
}
