package com.github.morningwn.t0501_t1000.t0601_t0700.t0631_t0640;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/solve-the-equation/">640. 求解方程</a>
 *
 * @author morningwn
 * @create in 2022/8/9 11:41
 */
public class T0640 {

    @Test
    public void test() {
//        String equation = "x=1"; 1
//        String equation = "4=2x+2"; 1
//        String equation = "x+5-3+x=6+x-2";
//        String equation = "x=x";
//        String equation = "2x=x";
        String equation = "x+5-3+x+32-23+12-3x+2-x+23+43-x+12x=63+x-2+2x";
//        String equation = "x=12x+43-12+40x-23+43";
//        String equation = "2x+3x-6x=x+2";
//        String equation = "0x=0";

        Out.println(solveEquation(equation));
    }

    public String solveEquation(String equation) {
        int lCoefficient = 0;
        int rCoefficient = 0;
        int lSum = 0;
        int rSum = 0;
        int type = 1;

        boolean flag = true;

        char[] chars = equation.toCharArray();
        int num = 0;
        boolean numVerification = true;

        for (char aChar : chars) {
            if (aChar == 'x') {
                if (numVerification && num == 0) {
                    num = 1;
                }
                if (flag) {
                    lCoefficient += type * num;
                } else {
                    rCoefficient += type * num;
                }
                num = 0;
            } else if (aChar == '-') {
                if (flag) {
                    lSum += type * num;
                } else {
                    rSum += type * num;
                }
                numVerification = true;

                type = -1;
                num = 0;
            } else if (aChar == '+') {
                if (flag) {
                    lSum += type * num;
                } else {
                    rSum += type * num;
                }
                numVerification = true;
                type = 1;
                num = 0;
            } else if (aChar == '=') {
                if (flag) {
                    lSum += type * num;
                } else {
                    rSum += type * num;
                }
                numVerification = true;
                flag = false;
                num = 0;
                type = 1;
            } else {
                numVerification = false;
                num = num * 10 + (aChar - '0');
            }
        }
        if (flag) {
            lSum += type * num;
        } else {
            rSum += type * num;
        }
        if (lCoefficient == rCoefficient && rSum != lSum) {
            return "No solution";
        } else if (lCoefficient == rCoefficient) {
            return "Infinite solutions";
        } else {
            int res = (rSum - lSum) / (lCoefficient - rCoefficient);
            return "x=" + res;
        }
    }
}
