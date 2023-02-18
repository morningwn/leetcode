package com.github.morningwn.t0001_t0500.t0001_t0100.t0001_t0010;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/reverse-integer/">7. 整数反转</a>
 *
 * @author morningwn
 * @date
 */
public class T0007 {

    @Test
    public void test() {
        Out.println(reverse(102));
    }

    public int reverse(int x) {

        int output = x % 10;
        int next = x / 10;

        while (next != 0) {

            if (((output % 100000000 * 10 + next % 10) >= 147483647 && output / 100000000 >= 2) ||
                    ((output % 100000000 * 10 + next % 10) <= -147483648 && output / 100000000 <= -2)) {
                return 0;
            }

            output = output * 10 + next % 10;
            next = next / 10;
        }

        return output;
    }

    public int reverse1(int x) {

        String input = (x + "");
        String output = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == '-') {
                output = input.charAt(i) + output;
            } else if (input.charAt(i) == '+') {
            } else {
                output += input.charAt(i);
            }
        }

        if (output.length() >= 11) {
            if (output.charAt(0) == '-') {
                if (output.length() == 11) {
                    if (output.charAt(1) > 50) {
                        return 0;
                    } else if (output.charAt(1) == 50) {
                        if (Integer.parseInt(output.substring(2)) > 147483648) {
                            return 0;
                        }
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else if (output.length() == 10) {
            if (output.charAt(0) != '-') {
                if (output.charAt(0) > 50) {
                    return 0;
                } else if (output.charAt(0) == 50) {
                    if (Integer.parseInt(output.substring(1)) >= 147483647) {
                        return 0;
                    }
                }
            }
        }

        return Integer.parseInt(output);
    }

}
