package com.github.morningwn.to_offer.t011_t020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/7/4 10:47
 */
public class T0014II {

    @Test
    public void test() {
        Out.println(cuttingRope(120));
    }

    /**
     * @author morningwn
     * @date 2020/7/4 10:54
     * @description: 尽可能的分割多的长度为3的段
     * @param: n 输入
     * @return: int 模1000000007后的结果
     */
    public int cuttingRope(int n) {

        if (n < 4) {
            return n - 1;
        }
        long res = 1;

        while (n > 4) {
            res = res * 3 % 1000000007;
            n -= 3;
        }
        if (n > 0) {
            res *= n;
        }

        res = res % 1000000007;
        return (int) res;
    }

}
