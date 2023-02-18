package com.github.morningwn.t0501_t1000.t0601_t0700.t0651_t0660;

/**
 * <a href="https://leetcode.cn/problems/robot-return-to-origin/">657. 机器人能否返回原点</a>
 *
 * @author morningwn
 * @date 2020/8/28  19:44
 */
public class T0657 {

    public boolean judgeCircle(String moves) {
        char[] m = moves.toCharArray();

        int x = 0;
        int y = 0;

        for (char s : m) {
            if (s == 'L') {
                x--;
            } else if (s == 'R') {
                x++;
            } else if (s == 'U') {
                y--;
            } else if (s == 'D') {
                y++;
            }
        }

        return x == 0 && y == 0;
    }
}
