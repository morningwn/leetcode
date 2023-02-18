package com.github.morningwn.t0501_t1000.t0801_t0900.t0841_t0850;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/keys-and-rooms/">841. 钥匙和房间</a>
 *
 * @author morningwn
 * @date 2020/8/31  10:00
 */
public class T0841 {
    private int[] index;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        index = new int[rooms.size()];

        helper(rooms, 0);
        for (int i : index) {
            if (i != 1) {
                return false;
            }
        }

        return true;
    }

    public void helper(List<List<Integer>> rooms, int i) {
        if (index[i] == 0) {
            index[i] = 1;
        } else {
            return;
        }

        for (int m = 0; m < rooms.get(i).size(); m++) {
            helper(rooms, rooms.get(i).get(m));
        }
    }
}
