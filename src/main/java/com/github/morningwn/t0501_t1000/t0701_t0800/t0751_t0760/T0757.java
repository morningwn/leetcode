package com.github.morningwn.t0501_t1000.t0701_t0800.t0751_t0760;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/set-intersection-size-at-least-two/">757. 设置交集大小至少为2</a>
 *
 * @author morningwn
 * @create in 2022/7/21 17:34
 */
public class T0757 {

    @Test
    public void test() {
    }

    public int intersectionSizeTwo(int[][] intervals) {
        int startMin = (int) 1e8;
        int startMax = 0;
        int endMin = (int) 1e8;
        int endMax = 0;

        for (int[] interval : intervals) {
            if (startMin > interval[0]) {
                startMin = interval[0];
            }
            if (startMax < interval[0] - 2) {
                startMax = interval[0] - 2;
            }
            if (endMin > interval[1]) {
                endMin = interval[0];
            }
            if (endMax < interval[1] + 2) {
                startMax = interval[1] + 2;
            }
        }

        return 0;
    }
}
