package com.github.morningwn.t0001_t0500.t0201_t0300.t0261_t0270;

/**
 * 丑数
 *
 * @author morningwn
 * @version 1.0.0
 * @date 2021/4/10 17:25
 */
public class T0263 {

    public boolean isUgly(int n) {

        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;

    }
}
