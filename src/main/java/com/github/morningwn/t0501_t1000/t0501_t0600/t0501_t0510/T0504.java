package com.github.morningwn.t0501_t1000.t0501_t0600.t0501_t0510;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/base-7/">504. 七进制数</a>
 *
 * @author morningwn
 * @date Created in 2022/3/7 18:38
 */
public class T0504 {

    @Test
    public void test() {
        Out.println(convertToBase7(43));
    }

    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
}
