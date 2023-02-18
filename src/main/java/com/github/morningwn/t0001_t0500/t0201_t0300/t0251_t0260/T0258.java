package com.github.morningwn.t0001_t0500.t0201_t0300.t0251_t0260;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/add-digits/">258. 各位相加</a>
 *
 * @author morningwn
 * @date Created in 2022/3/3 15:38
 */
public class T0258 {
    @Test
    public void test() {
        int num = Integer.MAX_VALUE;
        Out.println(num);
        Out.println(addDigits(num));
    }

    public int addDigits(int num) {

        while (num >= 10) {
            int res = 0;
            while (num > 0) {
                res += num % 10;
                num /= 10;
            }
            num = res;
        }

        return num;
    }
}
