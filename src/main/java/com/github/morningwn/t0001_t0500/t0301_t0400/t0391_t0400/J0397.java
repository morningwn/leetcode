package com.github.morningwn.t0001_t0500.t0301_t0400.t0391_t0400;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 397. 整数替换
 * <link>https://leetcode-cn.com/problems/integer-replacement/</link>
 *
 * @author morningwn
 * @date Created in 2021/11/19 11:08
 */
public class T0397 {

    @Test
    public void test() {
        Out.println((long) Math.pow(2, 31));
        int n = (int) Math.pow(2, 30) - 456;
        Out.println(integerReplacement(n));
    }

    public int integerReplacement(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                ++ans;
                n /= 2;
            } else if (n % 4 == 1) {
                ans += 2;
                n /= 2;
            } else {
                if (n == 3) {
                    ans += 2;
                    n = 1;
                } else {
                    ans += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return ans;
    }

    public int integerReplacement1(int n) {
        Map<Integer, Integer> dir = new HashMap<>();

        if (n == 2147483647) {
            return 32;
        }

        return hepler(n, dir);
    }

    public int hepler(int n, Map<Integer, Integer> dir) {
        if (n <= 1) {
            return 0;
        }
        if (n % 2 == 0) {
            if (dir.containsKey(n / 2)) {
                return 1 + dir.get(n / 2);
            } else {
                int tmp = hepler(n / 2, dir);
                dir.put(n / 2, tmp);
                return 1 + tmp;
            }

        } else {
            int tmp1 = 0;
            int tmp2 = 0;
            if (dir.containsKey(n + 1)) {
                tmp1 = dir.get(n + 1);
            } else {
                tmp1 = hepler(n + 1, dir);
                dir.put(n + 1, tmp1);
            }
            if (dir.containsKey(n - 1)) {
                tmp2 = dir.get(n - 1);
            } else {
                tmp2 = hepler(n - 1, dir);
                dir.put(n - 1, tmp2);
            }
            return 1 + Math.min(tmp1, tmp2);
        }
    }
}
