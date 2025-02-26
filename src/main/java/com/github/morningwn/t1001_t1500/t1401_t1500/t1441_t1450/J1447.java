package com.github.morningwn.t1001_t1500.t1401_t1500.t1441_t1450;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/simplified-fractions/">1447. 最简分数</a>
 *
 * @author morningwn
 * @date 2022-02-10 11:08:53
 */
public class J1447 {

    @Test
    public void test() {
        int n = 4;

        List<String> res = simplifiedFractions(n);

        Out.println(res);
    }

    public List<String> simplifiedFractions(int n) {

        List<String> res = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {

            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    res.add(i + "/" + j);
                }
            }

        }

        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
