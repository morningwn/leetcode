package com.github.morningwn.t1001_t1500.t1301_t1400.t1341_t1350;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * <a href="https://leetcode.cn/problems/maximum-students-taking-exam/">1349. 参加考试的最大学生数</a>
 * <ul>
 * <li>{@link Difficulty#Hard}</li>
 * <li>{@link Topic#BitManipulation}</li>
 * <li>{@link Topic#Array}</li>
 * <li>{@link Topic#DynamicProgramming}</li>
 * <li>{@link Topic#Bitmask}</li>
 * <li>{@link Topic#Matrix}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-12-26 15:46:04
 */
public class J1349 {

    @Test
    public void test() {
//        char[][] seats = {
//                {'#', '.', '#', '#', '.', '#'},
//                {'.', '#', '#', '#', '#', '.'},
//                {'#', '.', '#', '#', '.', '#'}
//        };
//        Out.println(maxStudents(seats));

        char[][] seats = {
                {'#', '.', '.', '.', '#'},
                {'.', '#', '.', '#', '.'},
                {'.', '.', '#', '.', '.'},
                {'.', '#', '.', '#', '.'},
                {'#', '.', '.', '.', '#'}
        };
//        {1={10=4}, 2={0=4}, 3={9=2}, 4={1=1}, 5={4=0}}
        Out.println(maxStudents(seats));
        System.out.println(res);
    }

    public int maxStudents(char[][] seats) {
        return chooseSeat(seats, 0, 0, 0, 0);
    }

    Map<Integer, Map<Integer, Integer>> res = new HashMap<>();

    private int chooseSeat(char[][] seats, int x, int y, int preMsk, int curMask) {
        if (res.containsKey(x) && res.get(x).containsKey(preMsk)) {
            return res.get(x).get(preMsk);
        }
        if (x >= seats.length) {
            return 0;
        }
        if (y >= seats[x].length) {
            int count = chooseSeat(seats, x + 1, 0, curMask, 0);
            res.computeIfAbsent(x + 1, k -> new HashMap<>()).put(curMask, count);
            return count;
        }
        int count = 0;
        if (seats[x][y] == '.' && check(preMsk, curMask, x, y, seats)) {
            count = 1 + chooseSeat(seats, x, y + 2, preMsk, curMask | 1 << y);
        }
        count = Math.max(count, chooseSeat(seats, x, y + 1, preMsk, curMask));
        return count;
    }

    private boolean check(int preMask, int curMask, int x, int y, char[][] seats) {
        if (y > 0) {
            if ((preMask & (1 << (y - 1))) != 0 || (curMask & (1 << (y - 1))) != 0) {
                return false;
            }
        }
        if (y <= seats[0].length - 2) {
            if ((preMask & (1 << (y + 1))) != 0 || (curMask & (1 << (y + 1))) != 0) {
                return false;
            }
        }
        return true;
    }
}
