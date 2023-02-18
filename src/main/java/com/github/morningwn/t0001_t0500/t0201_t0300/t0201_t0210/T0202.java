package com.github.morningwn.t0001_t0500.t0201_t0300.t0201_t0210;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningwn
 * @description: 快乐数
 * @date Created in 2020/4/30 9:11
 * @version: 1.0
 */
public class T0202 {

    @Test
    public void test() {
        Out.println(isHappy(2));
    }

    /**
     * 通过记忆的手法判断这个数是否为快乐数
     *
     * @param n 一个数
     * @return 判断结果
     */
    public boolean isHappy(int n) {

        List<Integer> memory = new ArrayList<>();
        int num = 0;
        while (n != 1) {

            num = n;
            n = 0;
            while (num != 0) {
                n += Math.pow(num % 10, 2);
                num = num / 10;
            }

            if (memory.contains(n)) {
                return false;
            } else {
                memory.add(n);
            }
        }

        return true;
    }

}
