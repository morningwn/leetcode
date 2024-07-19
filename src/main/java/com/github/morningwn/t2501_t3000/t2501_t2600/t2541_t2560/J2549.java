package com.github.morningwn.t2501_t3000.t2501_t2600.t2541_t2560;

/**
 * <a href="https://leetcode.cn/problems/count-distinct-numbers-on-board/description/">2549. 统计桌面上的不同数字</a>
 *
 * @author morningwn
 * @date Created in 2024/7/19 18:00
 */
public class J2549 {
    public int distinctIntegers(int n) {
        if (n == 1) {
            return 1;
        }
        return n - 1;
    }
}