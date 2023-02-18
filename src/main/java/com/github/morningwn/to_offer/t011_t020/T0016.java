package com.github.morningwn.to_offer.t011_t020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/7/4 15:18
 */
public class T0016 {

    @Test
    public void test() {
        Out.println(myPow(34.00515, -3));
    }

    /**
     * @author morningwn
     * @date 2020/7/4 15:31
     * @description: 分治策略，对半分
     * @param: x 一个数
     * @param: n 指数
     * @return: double 结果
     */
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
