package com.github.morningwn.t0001_t0500.t0401_t0500.t0471_t0480;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/ones-and-zeroes/">474. 一和零</a>
 *
 * @author morningwn
 * @version 1.0.0
 * @date 2021/6/6 23:04
 */
public class T0474 {

    @Test
    public void test() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;

        Out.println(findMaxForm(strs, m, n));
    }

    /**
     * 动态规划
     *
     * @param strs
     * @param m    0的数量
     * @param n    1的数量
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] count = new int[m + 1][n + 1][strs.length + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 1; k <= strs.length; k++) {
                    int zero = 0;
                    int one = 0;
                    for (char c : strs[k - 1].toCharArray()) {
                        if (c == '0') {
                            zero += 1;
                        } else {
                            one += 1;
                        }
                    }

                    if (i - zero >= 0 && j - one >= 0) {
                        count[i][j][k] = Math.max(count[i - zero][j - one][k - 1] + 1, count[i][j][k - 1]);
                    } else {
                        count[i][j][k] = count[i][j][k - 1];
                    }

                    Out.println("i: " + i + "\t j: " + j + "\t k: " + k + "\t count: " + count[i][j][k]);
                }

                Out.println();
            }
        }


        return count[m][n][strs.length];
    }
}
