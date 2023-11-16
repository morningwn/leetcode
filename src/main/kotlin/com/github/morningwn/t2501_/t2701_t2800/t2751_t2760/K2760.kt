package com.github.morningwn.t2501_.t2701_t2800.t2751_t2760

import kotlin.math.max

/**
 * <a href="https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/">2760. 最长奇偶子数组</a>
 *
 * @author morningwn
 * @date 2023/11/16 15:52
 */
class K2760 {

    fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
        var maxSubLength = 0;
        var subLength = 0;
        var flag = 1;
        for (num in nums) {
            if (num <= threshold) {
                if (flag == 1 && num % 2 == 0) {
                    flag = -1
                    subLength++
                } else if (flag == -1 && num % 2 == 1) {
                    flag = 1
                    subLength++
                } else {
                    maxSubLength = max(maxSubLength, subLength)
                    if (num % 2 == 0) {
                        flag = -1
                        subLength = 1
                    } else {
                        flag = 1
                        subLength = 0
                    }

                }
            } else {
                flag = 1;
                maxSubLength = max(maxSubLength, subLength)
                subLength = 0;
            }
        }
        maxSubLength = max(maxSubLength, subLength)
        return maxSubLength
    }
}