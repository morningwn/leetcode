package com.github.morningwn.t0001_t0500.t0001_t0100.t0061_t0070;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date
 */
public class T0070 {

    @Test
    public void test() {
        Out.println(climbStairs(2));       //2
        Out.println(climbStairs(3));       //2
        Out.println(climbStairs(45));       //2

    }

    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

}
