package com.github.morningwn.t0001_t0500.t0401_t0500.t0471_t0480;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/matchsticks-to-square/">473. 火柴拼正方形</a>
 *
 * @author moringwn
 * @create in 2022/6/1 10:03
 */
public class T0473 {

    /* =====================================================暴力循环版本======================================================= */
    private int[] matchsticks;

//    public boolean makesquare(int[] matchsticks) {
//        return false;
//    }

    @Test
    public void test() {
//        int[] matchsticks = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        int[] matchsticks = {1,2,3,4,5,6,7,8,9,10,5,4,3,3,2};
        int[] matchsticks = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 102};

        Out.println();
        Out.println(makesquare(matchsticks));
    }

    public boolean makesquare(int[] matchsticks) {
        this.matchsticks = matchsticks;
        int sum = Arrays.stream(matchsticks).sum();
        // 有余数直接返回
        if (sum % 4 != 0) {
            return false;
        }
        int max = sum / 4;
        Arrays.sort(matchsticks);

        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            if (matchsticks[i] > max || matchsticks[j] > max) {
                return false;
            }
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        return helper(max, 0, 0, 0, 0, 0);
    }

    private boolean helper(int max, int a, int b, int c, int d, int index) {
        if (a > max || b > max || c > max || d > max) {
            return false;
        }
        if (index >= matchsticks.length) {
            return a == b && b == c && c == d;
        }

        return helper(max, a + matchsticks[index], b, c, d, index + 1) ||
                helper(max, a, b + matchsticks[index], c, d, index + 1) ||
                helper(max, a, b, c + matchsticks[index], d, index + 1) ||
                helper(max, a, b, c, d + matchsticks[index], index + 1);
    }
}
