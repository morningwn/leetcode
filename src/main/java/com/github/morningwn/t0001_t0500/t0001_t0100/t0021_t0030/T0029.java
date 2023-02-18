package com.github.morningwn.t0001_t0500.t0001_t0100.t0021_t0030;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/divide-two-integers/">29. 两数相除</a>
 *
 * @author morningwn
 * @date Created in
 */
public class T0029 {

    @Test
    public void test() {

        Out.println(divide(-2147483647, 2) + " \t" + (-2147483647 / 2));
        Out.println(divide(-2147483647, -2) + " \t" + (-2147483647 / -2));
        Out.println(divide(2147483647, 2) + " \t" + (2147483647 / 2));


        Out.println(divide(2147483647, 1) + " \t" + (2147483647));
        Out.println(divide(-2147483648, 1) + " \t" + (-2147483648));
        Out.println(divide(2147483647, -1) + " \t" + (2147483647 / -1));
        Out.println(divide(-2147483648, -1) + " \t" + (-2147483648 / -1));


        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 1000);
            int b = (int) (Math.random() * 100);
            Out.println(divide(a, b) == (a / b));
        }

        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 1000);
            int b = (int) (Math.random() * 100);
            Out.println(divide(-a, b) == (-a / b));
        }

        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 1000);
            int b = (int) (Math.random() * 100);
            Out.println(divide(a, -b) == (a / -b));
        }

        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 1000);
            int b = (int) (Math.random() * 100);
            Out.println(divide(-a, -b) == (-a / -b));
        }

    }

    public int divide(int dividend, int divisor) {

        //判断是否是被除数为0，被除数除数均为最小值，除数为最小值
        //并对相应的情况进行处理
        if (dividend == 0 || divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        int a = 0;                      //被除数的绝对值
        int b = Math.abs(divisor);      //除数的绝对值
        boolean special = false;        //被除数是否是最小值

        int result = 0;                 //商
        int tmp = b;                    //暂时存储移位的结果
        int stape = 1;                  //暂时存储当前移位的值

        //判断被除数是否是最小值，并取其绝对值
        if (dividend != Integer.MIN_VALUE) {
            a = Math.abs(dividend);
        } else {
            a = Math.abs(dividend + 1);
            special = true;
        }

        //当被除数小于除数时循环结束
        while (a >= b) {

            //判断此次位移结果是否会越界
            //不越界就进行位移，可能会越界就进行加减和初始化操作
            if (tmp < Integer.MAX_VALUE >> 2) {

                //当位移结果小于被除数时，继续进行位移操作
                //当大于时，就用被除数减去位移结果，并将stape的值加在result上
                //同时将结果tmp、stape再次初始化
                if (tmp << 2 < a) {
                    tmp = tmp << 2;
                    stape = stape << 2;
                } else {
                    a = a - tmp;
                    tmp = b;
                    result += stape;
                    stape = 1;
                }
            } else {
                a = a - tmp;
                tmp = b;
                result += stape;
                stape = 1;
            }
        }

        //将result的符号修正
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            result = -result;
        }

        //若被除数是最小值，将上面减去的1重新加回来，并进行计算
        if (special && a + 1 == b) {

            //判断计算结果是否会越界
            if (result == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                result = result - 1;
            }
        }

        return result;
    }


    public int divide1(int dividend, int divisor) {

        if (dividend == 0) {
            return 0;
        }
        int result = 0;
        int tmp = divisor;
        int stape = 1;

        if (dividend > 0 && divisor > 0) {
            while (dividend >= divisor) {

                if (tmp < Integer.MAX_VALUE >> 2) {
                    if (tmp << 2 < dividend) {
                        tmp = tmp << 2;
                        stape = stape << 2;
                    } else {
                        dividend = dividend - tmp;
                        tmp = divisor;
                        result += stape;
                        stape = 1;
                    }
                } else {
                    dividend = dividend - tmp;
                    tmp = divisor;
                    result += stape;
                    stape = 1;
                }

            }
        } else if (dividend > 0 && divisor < 0) {
            while (dividend >= divisor) {

                if (tmp < Integer.MIN_VALUE >> 2) {
                    if (tmp << 2 < dividend) {
                        tmp = tmp << 2;
                        stape = stape << 2;
                    } else {
                        dividend = dividend + tmp;
                        tmp = divisor;
                        result -= stape;
                        stape = 1;
                    }
                } else {
                    dividend = dividend + tmp;
                    tmp = divisor;
                    result -= stape;
                    stape = 1;
                }

            }

            result += 2;

        } else if (dividend < 0 && divisor > 0) {
            while (dividend <= divisor) {

                if (tmp < Integer.MIN_VALUE >> 2) {
                    if (tmp << 2 < dividend) {
                        tmp = tmp << 2;
                        stape = stape << 2;
                    } else {
                        dividend = dividend + tmp;
                        tmp = divisor;
                        result -= stape;
                        stape = 1;
                    }
                } else {
                    dividend = dividend + tmp;
                    tmp = divisor;
                    result -= stape;
                    stape = 1;
                }

            }

            result += 2;

        } else {
            while (dividend <= divisor) {

                if (result == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }

                if (tmp < Integer.MIN_VALUE >> 2) {
                    if (tmp << 2 < dividend) {
                        tmp = tmp << 2;
                        stape = stape << 2;
                    } else {
                        dividend = dividend - tmp;
                        tmp = divisor;
                        result += stape;
                        stape = 1;
                    }
                } else {
                    dividend = dividend - tmp;
                    tmp = divisor;
                    result += stape;
                    stape = 1;
                }

            }
        }

        return result;
    }

}
