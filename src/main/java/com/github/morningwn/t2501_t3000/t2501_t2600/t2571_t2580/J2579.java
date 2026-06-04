package com.github.morningwn.t2501_t3000.t2501_t2600.t2571_t2580;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/count-total-number-of-colored-cells/">2579. 统计染色格子数</a>
 *
 * @author morningwn
 * @date Created in 2023/3/4 22:46
 */
public class J2579 {

    @Test
    public void test() {
        int n = 6;
        Out.println(coloredCells(n));
    }

    public long coloredCells(int n) {
        long cellCount = 1L;
        long step = 4L;
        for (int i = 1; i < n; i++) {
            cellCount += step;
            step += 4L;
        }
        return cellCount;
    }
}
