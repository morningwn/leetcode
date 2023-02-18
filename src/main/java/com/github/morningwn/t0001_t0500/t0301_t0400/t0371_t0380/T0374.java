package com.github.morningwn.t0001_t0500.t0301_t0400.t0371_t0380;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/5/27 9:45
 */
public class T0374 {
    @Test
    public void test() {

        Out.println(guessNumber(1));
    }

    public int guessNumber(int n) {
        int l = 1, r = n;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int gu = guess(m);

            Out.println(m + "\t " + gu);
            if (gu == 0) {
                return m;
            } else if (gu == -1) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }

    public int guess(int num) {
        int target = 1;
        if (target == num) {
            return 0;
        } else if (target < num) {
            return -1;
        } else {
            return 1;
        }
    }

}
