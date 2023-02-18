package com.github.morningwn.to_offer.t001_t010;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/7/2 13:51
 */
public class T010_I {

    @Test
    public void test() {
        Out.println(fib(1));
        Out.println(fib1(1));
    }

    /**
     * @param n 输入n
     * @return int 返回第n个数的值
     * @author morningwn
     * @date 2020/7/2 13:58
     * @description: 使用公式，时间复杂度降至对数级
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int[][] matrix = {{1, 1}, {1, 0}};
        int[][] res = matrix;
        if (n > 1) {
            res = helper(n - 1, matrix);
        }
        return res[0][0];
    }

    /**
     * @param n      输入n
     * @param matrix 矩阵
     * @return int[][] n次幂的结果
     * @author morningwn
     * @date 2020/7/2 14:43
     * @description: 求矩阵的n次幂
     */
    public int[][] helper(int n, int[][] matrix) {

        //n=1.直接返回结果，无需再进行分割
        if (n == 1) {
            return matrix;
        }

        int[][] helf;

        //n为偶数 分割成两个n/2，然后相乘
        if (n % 2 == 0) {
            helf = helper(n / 2, matrix);
            int a = helf[0][0] * helf[0][0] + helf[0][1] * helf[1][0];
            int b = helf[0][0] * helf[0][1] + helf[0][1] * helf[1][1];
            int c = helf[0][0] * helf[1][0] + helf[1][0] * helf[1][1];
            int d = helf[0][1] * helf[1][0] + helf[1][1] * helf[1][1];
            return new int[][]{{a, b}, {c, d}};
        } else { //n为奇数，分割成两个(n-1)/2相乘后再乘一个matrix
            helf = helper((n - 1) / 2, matrix);
            int a = helf[0][0] * helf[0][0] + helf[0][1] * helf[1][0];
            int b = helf[0][0] * helf[0][1] + helf[0][1] * helf[1][1];
            int c = helf[0][0] * helf[1][0] + helf[1][0] * helf[1][1];
            int d = helf[0][1] * helf[1][0] + helf[1][1] * helf[1][1];
            return new int[][]{{a + b, a}, {c + d, c}};
        }

    }

    /**
     * @param n 输入n
     * @return int 返回第n个数的值模1000000007后的结果
     * @author morningwn
     * @date 2020/7/2 13:51
     * @description: 求斐波那契数列，连续迭代得到结果
     * @version: 1.0
     */
    public int fib1(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] counts = new int[n + 1];
        counts[0] = 0;
        counts[1] = 1;

        for (int i = 2; i <= n; i++) {
            counts[i] = (counts[i - 1] + counts[i - 2]) % 1000000007;
        }

        return counts[n];
    }

}
