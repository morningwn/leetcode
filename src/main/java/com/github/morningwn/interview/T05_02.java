package com.github.morningwn.interview;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/bianry-number-to-string-lcci/"></a>
 *
 * @author morningwn
 * @date Created in 2023/3/2 00:15
 */
public class T05_02 {

    @Test
    public void test() {
        double num = 0.1;
        Out.println(printBin(num));
    }

    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (num != 0 && sb.length() <= 32) {
            num *= 2;
            int digit = (int) num;
            sb.append(digit);
            num -= digit;
        }
        return sb.length() > 32 ? "ERROR" : sb.toString();
    }
}
