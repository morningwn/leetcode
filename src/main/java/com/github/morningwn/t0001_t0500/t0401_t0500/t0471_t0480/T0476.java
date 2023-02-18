package com.github.morningwn.t0001_t0500.t0401_t0500.t0471_t0480;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/number-complement/">476. 数字的补数</a>
 *
 * @author moringwn
 * @date 2021/10/18 上午9:35
 */
public class T0476 {

    @Test
    public void test() {
        int num = 5;
        Out.println(findComplement(num));
    }

    public int findComplement(int num) {

        int res = 0;
        int bit = 1;

        while (num > 0) {
            if ((num & bit) == 0) {
                res |= bit;
            } else {
                num ^= bit;
            }

            bit <<= 1;
        }

        return res;
    }
}
