package com.github.morningwn.t2001_t2500.t2001_t2100.t2041_t2050;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/next-greater-numerically-balanced-number/">2048. 下一个更大的数值平衡数</a>
 *
 * @author morningwn
 * @date Created in 2021/10/24 11:15
 */
public class J2048 {

    @Test
    public void test() {
        int num = 23;
        Out.println(nextBeautifulNumber(num));
    }

    public int nextBeautifulNumber(int n) {

        int num = n + 1;

        while (true) {
            if (judge(num)) {
                return num;
            } else {
                num++;
            }
        }
    }

    public boolean judge(int n) {
        int[] count = new int[10];
        int tmp = n;

        while (tmp > 0) {
            count[tmp % 10]++;
            tmp /= 10;
        }

        if (count[0] != 0) {
            return false;
        }

        for (int i = 1; i < 10; i++) {
            if (count[i] != 0 && count[i] != i) {
                return false;
            }
        }

        return true;
    }
}
