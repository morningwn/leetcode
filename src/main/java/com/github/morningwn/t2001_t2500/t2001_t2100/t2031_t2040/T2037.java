package com.github.morningwn.t2001_t2500.t2001_t2100.t2031_t2040;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-moves-to-seat-everyone/">2037. 使每位学生都有座位的最少移动次数</a>
 * @author morningwn
 * @create in 2022/12/31 12:42
 */
public class T2037 {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }

        return moves;
    }
}
