package com.github.morningwn.t1001_t1500.t1001_t1100.t1051_t1060;

import java.util.Arrays;

/**
 * <a hraf="https://leetcode.cn/problems/height-checker/">1051. 高度检查器</a>
 *
 * @author moringwn
 * @create in 2022/6/13 9:57
 */
public class T1051 {

    public int heightChecker(int[] heights) {
        int length = heights.length;
        int[] copyHeight = Arrays.copyOf(heights, length);
        Arrays.sort(copyHeight);

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (copyHeight[i] != heights[i]) {
                count++;
            }
        }

        return count;
    }
}
