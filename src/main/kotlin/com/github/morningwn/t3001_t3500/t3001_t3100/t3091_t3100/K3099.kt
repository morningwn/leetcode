package com.github.morningwn.t3001_t3500.t3001_t3100.t3091_t3100

/**
 * <a href="https://leetcode.cn/problems/harshad-number/description/">3099. 哈沙德数</a>
 *
 * @author morningwn
 * @date 2024/7/3 14:23
 */
class K3099 {

    fun sumOfTheDigitsOfHarshadNumber(x: Int): Int {
        var tmp = x
        var sum = 0
        while (tmp > 0) {
            sum += tmp % 10
            tmp /= 10
        }
        return if (x % sum == 0) sum else -1
    }
}