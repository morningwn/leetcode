package com.github.morningwn.t2501_.t2501_t2600.t2651_t2660

/**
 * <a href="https://leetcode.cn/problems/maximum-sum-with-exactly-k-elements/">2656. K 个元素的最大和</a>
 *
 * @author wangjianing
 * @date 2023/11/15 10:35
 */
class K2656 {
    fun maximizeSum(nums: IntArray, k: Int): Int {
        var maxNum = Int.MIN_VALUE
        for (num in nums) {
            if (num > maxNum) {
                maxNum = num
            }
        }
        return maxNum * k + ((k - 1) * k) / 2
    }
}