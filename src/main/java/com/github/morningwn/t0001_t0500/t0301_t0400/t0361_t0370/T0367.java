package com.github.morningwn.t0001_t0500.t0301_t0400.t0361_t0370;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 367. 有效的完全平方数
 * <link>https://leetcode-cn.com/problems/valid-perfect-square/</link>
 *
 * @author moringwn
 * @date 2021/11/4 上午9:56
 */
public class T0367 {

    @Test
    public void test() {
        int num = 1;
        Out.println(isPerfectSquare(num));
        Out.println(isPerfectSquare1(num));

    }

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;

        while (left <= right) {
            long middle = left + (right - left) / 2;
            long product = middle * middle;

            if (product > num) {
                right = (int) (middle - 1);
            } else if (product < num) {
                left = (int) (middle + 1);
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean isPerfectSquare1(int num) {
        if (num == 1) {
            return true;
        }
        int n = Math.min(num / 2, 46340);
        int product = 0;

        while (true) {
            product = n * n;
            if (product == num) {
                return true;
            } else if (product > num) {
                n--;
            } else {
                return false;
            }
        }
    }
}
