package com.github.morningwn.t0001_t0500.t0001_t0100.t0061_t0070;

/**
 * @author morningwn
 * @date Created in 2020/4/30 16:19
 */
public class T0066 {


    public int[] plusOne(int[] digits) {

        int carry = 0;
        int len = digits.length - 1;
        carry = ++digits[len] / 10;

        if (carry == 0) {
            return digits;
        } else {

        }

        return null;
    }

}
