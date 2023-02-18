package com.github.morningwn.t0001_t0500.t0301_t0400.t0371_t0380;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 两整数之和
 *
 * @author moringwn
 * @date 2021/9/26 上午9:28
 */
public class T0371 {

    @Test
    public void test() {
        int a = 2342;
        int b = -234;
        Out.println(Integer.toBinaryString(a));
        Out.println(Integer.toBinaryString(b));
        Out.println(getSum(a, b));
        Out.println(a + b);

    }

    public int getSum(int a, int b) {

        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
