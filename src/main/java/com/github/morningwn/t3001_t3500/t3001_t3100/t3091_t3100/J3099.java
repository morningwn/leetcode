package com.github.morningwn.t3001_t3500.t3001_t3100.t3091_t3100;

/**
 * <a href="https://leetcode.cn/problems/harshad-number/description/">3099. 哈沙德数</a>
 *
 * @author morningwn
 * @date 2024/7/3 14:18
 */
public class J3099 {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int tmp = x;
        int sum = 0;

        while (tmp > 0) {
            sum += tmp % 10;
            tmp = tmp / 10;
        }

        return x % sum == 0 ? sum : -1;
    }
}
