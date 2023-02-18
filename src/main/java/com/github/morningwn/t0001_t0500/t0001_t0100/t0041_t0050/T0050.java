package com.github.morningwn.t0001_t0500.t0001_t0100.t0041_t0050;

import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/5/11 21:13
 */
public class T0050 {
    @Test
    public void test() {

    }

    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1.0;
        }
        if (n == -1) {
            return 1.0 / x;
        }

        if (n % 2 == 0) {
            double tmp = myPow(x, n / 2);
            return tmp * tmp;
        } else {
            if (n < 0) {
                double tmp = myPow(x, (n + 1) / 2);
                return tmp * tmp / x;
            } else {
                double tmp = myPow(x, (n - 1) / 2);
                return tmp * tmp * x;
            }
        }
    }
}
