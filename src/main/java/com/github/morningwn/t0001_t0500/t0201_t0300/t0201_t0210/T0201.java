package com.github.morningwn.t0001_t0500.t0201_t0300.t0201_t0210;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 数字范围按位与
 *
 * @author morningwn
 * @version 1.0
 * @date Created in 2020-08-23 18:49
 */
public class T0201 {

    @Test
    public void test() {

        int m = 131324223;
        int n = 2147483646;

        int res = rangeBitwiseAnd(m, n);
        Out.println(res);
        Out.println(helper(m, n));

    }

    public int rangeBitwiseAnd(int m, int n) {

        if (m == n) {
            return m;
        }

        int len1 = getLength(m);
        int len2 = getLength(n);

        if (len1 == len2 && len1 > 0) {
            int min = (int) Math.pow(2, Math.min(len1, len2) - 1);
            if (n - m >= min) {
                return min;
            } else {
                int res = m;
                for (int i = m + 1; n - i >= 0; i++) {
                    res &= i;
                }
                return res;
            }
        } else {
            return 0;
        }

    }

    public int getLength(int num) {
        return Integer.toString(num, 2).length();
    }

    public int helper(int m, int n) {
        int res = m;
        for (int i = m + 1; i <= n; i++) {
            res &= i;
        }
        return res;
    }
}
