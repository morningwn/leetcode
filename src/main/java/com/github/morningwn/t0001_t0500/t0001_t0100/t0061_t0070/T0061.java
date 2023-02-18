package com.github.morningwn.t0001_t0500.t0001_t0100.t0061_t0070;

/**
 * <a href="https://leetcode-cn.com/problems/plus-one/">66. 加一</a>
 *
 * @author moringwn
 * @date 2021/10/21 上午9:50
 */
public class T0061 {

    public int[] plusOne(int[] digits) {

        int carry = 1;
        int tmp = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            tmp = digits[i];
            digits[i] = (tmp + carry) % 10;
            carry = (tmp + carry) / 10;
        }

        if (carry == 1) {
            int[] ints = new int[digits.length + 1];
            System.arraycopy(digits, 0, ints, 1, digits.length);
            ints[0] = carry;
            return ints;
        } else {
            return digits;
        }

    }
}
