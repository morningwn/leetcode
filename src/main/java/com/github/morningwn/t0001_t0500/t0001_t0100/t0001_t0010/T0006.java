package com.github.morningwn.t0001_t0500.t0001_t0100.t0001_t0010;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/zigzag-conversion/">6. Z 字形变换</a>
 *
 * @author morningwn
 * @date Created in 2022/3/1 17:07
 */
public class T0006 {

    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int count = 0;
        int i = 1;
        int j = 1;

        while (count < s.length()) {
            if (i % (numRows - 1) == 1 || numRows == 2) {
                rows[j - 1].append(s.charAt(count++));
                if (j + 1 <= numRows) {
                    j++;
                } else {
                    i++;
                    j--;
                }
            } else {
                rows[j - 1].append(s.charAt(count++));
                i++;
                j--;
            }
        }

        String output = "";

        for (int k = 0; k < numRows; k++) {
            output += rows[k].toString();
        }

        return output;
    }

    @Test
    public void test() {
        String s = "PAYPALISHIRING";
        Out.println(convert(s, 3));
    }

}
