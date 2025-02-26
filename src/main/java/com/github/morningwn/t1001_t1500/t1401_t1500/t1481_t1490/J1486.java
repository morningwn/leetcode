package com.github.morningwn.t1001_t1500.t1401_t1500.t1481_t1490;

/**
 * <a href="https://leetcode.cn/problems/xor-operation-in-an-array/>1486. 数组异或操作</a>
 *
 * @author morningwn
 * @date Created in 2020/7/20 17:54
 */
public class J1486 {

    public int xorOperation(int n, int start) {
        int res = start;

        for (int i = 1; i < n; i++) {
            res ^= (start + 2 * i);
        }

        return res;
    }
}
