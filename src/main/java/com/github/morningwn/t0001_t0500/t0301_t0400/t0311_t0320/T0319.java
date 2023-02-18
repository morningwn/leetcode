package com.github.morningwn.t0001_t0500.t0301_t0400.t0311_t0320;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 319. 灯泡开关
 * <link>https://leetcode-cn.com/problems/bulb-switcher/</link>
 *
 * @author morningwn
 * @date Created in 2021/11/15 10:15
 */
public class T0319 {

    @Test
    public void test() {
        int n = 0;

        Out.println(bulbSwitch(n));
    }

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }

    /**
     * 结果正确，但是超时
     *
     * @param n
     * @return
     */
    public int bulbSwitch1(int n) {

        int[] flag = new int[n];
        for (int i = 2; i <= n; i++) {

            for (int j = 0, index = 1; j < n; j++, index++) {

                if (index == i) {
                    index = 0;
                    flag[j] = flag[j] == 0 ? -1 : 0;
                }
            }
        }

        int count = 0;
        for (int i : flag) {
            if (i == 0) {
                count++;
            }
        }

        return count;
    }
}
