package com.github.morningwn.to_offer.t001_t010;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/7/2 14:50
 */
public class T010_II {

    @Test
    public void test() {
        Out.println(numWays(7));
    }

    /**
     * @param n 一个值n
     * @return int n的结果模1000000007后的值
     * @author morningwn
     * @date 2020/7/2 15:04
     * @description: 就是斐波那契数列
     */
    public int numWays(int n) {

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; i++) {
            count[i] = (count[i - 1] + count[i - 2]) % 1000000007;
        }
        return count[n];
    }
}
