package com.github.morningwn.t0001_t0500.t0001_t0100.t0061_t0070;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/4/30 15:12
 */
public class T0067 {

    @Test
    public void test() {

        String a = "1010";
        String b = "1011";
        Out.println(addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        StringBuilder res = new StringBuilder();
        int i1 = num1.length - 1;
        int i2 = num2.length - 1;
        int next = 0;
        while (i1 >= 0 && i2 >= 0) {
            int t1 = num1[i1--] - '0';
            int t2 = num2[i2--] - '0';
            res.append(next ^ t1 ^ t2);
            next = (next & t1 & t2) | (t1 & t2) | (next & t1) | (next & t2);
//            next = (next + t1 + t2)/2;

            while (i1 >= 0 && i2 < 0) {
                t1 = num1[i1--] - '0';
                res.append(next ^ t1);
                next = next & t1;
            }
            while (i1 < 0 && i2 >= 0) {
                t2 = num2[i2--] - '0';
                res.append(next ^ t2);
                next = next & t2;
            }

        }
        if (next == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }

}
