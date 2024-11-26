package com.github.morningwn.t3001_t3500.t3201_t3300.t3201_t3210;

/**
 * <a href="https://leetcode.cn/problems/alternating-groups-i">3206. 交替组 I</a>
 *
 * @author morningwn
 * @date 2024-11-26 15:12:24
 */
public class J3206 {


    public int numberOfAlternatingGroups(int[] colors) {
        int groupCount = 0;
        int length = colors.length;
        for (int i = 0; i < colors.length; i++) {
            int pre = (i - 1 + length) % length;
            int next = (i + 1 + length) % length;
            if (colors[i] != colors[pre] && colors[i] != colors[next] && colors[pre] == colors[next]) {
                groupCount++;
            }
        }

        return groupCount;
    }

}