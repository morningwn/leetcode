package com.github.morningwn.t0001_t0500.t0001_t0100.t0001_t0010;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/string-to-integer-atoi/">8. 字符串转换整数 (atoi)</a>
 *
 * @author morningwn
 * @date
 */
public class T0008 {

    @Test
    public void test() {
        Out.println(myAtoi("      -11919730356x"));

    }

    public int myAtoi(String str) {

        String output = "";

        int i = 0;
        boolean start = false;

        while (i < str.length()) {

            char temp = str.charAt(i);

            if (temp >= 48 && temp <= 57) {
                if (temp == 48 && (output.length() == 0 || ("-".equals(output)))) {
                    start = true;
                    i++;
                } else {
                    start = true;
                    output += (temp + "");
                    i++;
                }
            } else if (temp == '-') {
                if (!start) {
                    output += (temp + "");
                    start = true;
                    i++;
                } else {
                    break;
                }
            } else if (temp == ' ') {
                if (!start) {
                    i++;
                } else {
                    break;
                }
            } else if (temp == '+') {
                if (!start) {
                    start = true;
                    i++;
                } else {
                    break;
                }
            } else {
                break;
            }

        }
        if (output.length() >= 11) {
            if (output.charAt(0) == '-') {
                if (output.length() == 11) {
                    if (output.charAt(1) > 50) {
                        return Integer.MIN_VALUE;
                    } else if (output.charAt(1) == 50) {
                        if (Integer.parseInt(output.substring(2)) > 147483648) {
                            return Integer.MIN_VALUE;
                        }
                    }
                } else {
                    return Integer.MIN_VALUE;
                }
            } else {
                return Integer.MAX_VALUE;
            }
        } else if (output.length() == 10) {
            if (output.charAt(0) != '-') {
                if (output.charAt(0) > 50) {
                    return Integer.MAX_VALUE;
                } else if (output.charAt(0) == 50) {
                    if (Integer.parseInt(output.substring(1)) >= 147483647) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
        }
        if (output != "" && !"-".equals(output)) {
            return Integer.parseInt(output);
        } else {
            return 0;
        }

    }

}
