package com.github.morningwn.t1001_t1500.t1301_t1400.t1341_t1350;

/**
 * <a href="https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-to-zero/">1342. 将数字变成 0 的操作次数</a>
 *
 * @author morningwn
 * @date 2020/7/20 18:13
 */
public class J1342 {

    public int numberOfSteps(int num) {
        int res = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }

            res++;
        }

        return res;
    }
}
