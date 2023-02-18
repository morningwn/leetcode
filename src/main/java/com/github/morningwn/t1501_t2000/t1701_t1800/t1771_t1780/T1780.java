package com.github.morningwn.t1501_t2000.t1701_t1800.t1771_t1780;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/check-if-number-is-a-sum-of-powers-of-three/">1780. 判断一个数字是否可以表示成三的幂的和</a>
 *
 * @author morningwn
 * @date 2022-12-09 09:48:28
 */
public class T1780 {

    @Test
    public void test() {
        Out.println(checkPowersOfThree(18));
    }

    public boolean checkPowersOfThree(int n) {

        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}