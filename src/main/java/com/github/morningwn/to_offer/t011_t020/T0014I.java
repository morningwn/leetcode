package com.github.morningwn.to_offer.t011_t020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @description: 剪绳子
 * @date Created in 2020/7/3 15:43
 * @version: 1.0
 */
public class T0014I {

    @Test
    public void test() {

        Out.println(cuttingRope(10));
        Out.println(cuttingRope1(10));

    }

    /**
     * @author morningwn
     * @date 2020/7/4 10:42
     * @description: 数学证明，尽可能多的分割长度为3的小段，乘积最大
     * @param: n 输入
     * @return: int 输出值
     */
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }

        int quotient = n / 3;
        int remainder = n % 3;
        int res;

        if (remainder == 1) {
            res = (int) Math.pow(3, quotient - 1) * 4;
        } else if (remainder == 2) {
            res = (int) Math.pow(3, quotient) * 2;
        } else {
            res = (int) Math.pow(3, quotient);
        }

        return res;
    }

    /**
     * @author morningwn
     * @date 2020/7/3 16:28
     * @description: 动态规划解法，在输入过大的情况下会越界
     * @version: 1.0
     * @param: n 绳子长度n
     * @return: int 乘积
     */
    public int cuttingRope1(int n) {

        if (n < 4) {
            return n - 1;
        }

        int[] maxProduct = new int[n + 1];

        maxProduct[1] = 1;
        maxProduct[2] = 2;
        maxProduct[3] = 3;

        for (int i = 4; i <= n; i++) {

            for (int k = 1; k < i; k++) {
                int tmp = maxProduct[i - k] * maxProduct[k];

                if (tmp > maxProduct[i]) {
                    maxProduct[i] = tmp;
                }
            }

            //Out.println(maxProduct[i]);
        }

        return maxProduct[n];
    }

}
