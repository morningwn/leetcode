package com.github.morningwn.t0501_t1000.t0601_t0700.t0641_t0650;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/2-keys-keyboard/">650. 只有两个键的键盘</a>
 *
 * @author morningwn
 * @date Created in 2021/9/19 21:22
 */
public class T0650 {

    @Test
    public void test() {
        Out.println(minSteps(1000));
    }

    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        if (n > 1) {
            return res + n;
        }
        return res;
    }

}
