package com.github.morningwn.t0001_t0500.t0001_t0100.t0061_t0070;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/5/9 10:14
 */
public class T0069 {

    @Test
    public void test() {
        Out.println(mySqrt(Integer.MAX_VALUE));
    }

    /**
     * 二分查询，找到结果
     *
     * @param x 一个非负整数
     * @return 开方结果，向下取整
     */
    public int mySqrt(int x) {

        int l = 0, r = x;

        while (l <= r) {
            long m = (l + r) / 2L;

            if (m * m > x) {
                if ((m - 1) * (m - 1) < x) {
                    return (int) m - 1;
                } else {
                    r = (int) m - 1;
                }
            } else {
                if ((m + 1) * (m + 1) > x) {
                    return (int) m;
                } else {
                    l = (int) m + 1;
                }
            }
        }

        return 0;
    }
}
