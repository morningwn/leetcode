package com.github.morningwn.t1001_t1500.t1301_t1400;

/**
 * @author morningwn
 * @description: 将数字变成 0 的操作次数
 * @date Created in 2020/7/20 18:13
 * @version: 1.0
 */
public class T1342 {

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
