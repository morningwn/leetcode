package com.github.morningwn.t1001_t1500.t1301_t1400;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T1323 {

    @Test
    public void test() {

        Out.println(maximum69Number(699));           //999
        Out.println(maximum69Number(6));             //9
        Out.println(maximum69Number(9699));           //9999
        Out.println(maximum69Number(0));           //

    }

    public int maximum69Number(int num) {

        String input = num + "";

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '6') {
                return Integer.parseInt(input.substring(0, i) + "9" + input.substring(i + 1));
            }
        }

        return num;
    }
}
