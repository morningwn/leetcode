package com.github.morningwn.t1001_t1500.t1301_t1400.t1331_t1340;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/">1335. 工作计划的最低难度</a>
 *
 * @author morningwn
 * @create in 2023/5/16 11:09
 */
public class T1335 {

    @Test
    public void test() {
        int[] jobDifficulty = {6,5,4,3,2,1,11,111,22,222,33,333,44,444,11,111,22,222,33,333,44,444,9,9,96,5,4,3,2,1,11,111,22,222,33,333,44,444,11,111,22,222,33,333,44,444,9,9,96,5,4,3,2,1,11,111,22,222,33,333,44,444,11,111,22,222,33,333,44,444,9,9,96,5,4,3,2,1,11,111,22,222,33,333,44,444,11,111,22,222,33,333,44,444,9,9,9};
        int d = 10;
        Out.println(minDifficulty(jobDifficulty, d));
    }

    private int[][] dir;

    public int minDifficulty(int[] jobDifficulty, int d) {
        dir = new int[jobDifficulty.length + 1][11];

        for (int i = 0; i < jobDifficulty.length + 1; i++) {
            Arrays.fill(dir[i], -2);
        }

        return helper(jobDifficulty, 0, d);
    }

    private int helper(int[] jobDifficulty, int index, int d) {
        if (dir[index][d] != -2) {
            return dir[index][d];
        }
        if (d == 0) {
            if (index == jobDifficulty.length) {
                dir[index][d] = 0;
                return 0;
            } else {
                dir[index][d] = -1;
                return -1;
            }
        }
        if (index + d > jobDifficulty.length) {
            dir[index][d] = -1;
            return -1;
        }

        int minDiff = Integer.MAX_VALUE;

        int i = index;
        int max = 0;
        while (i <= jobDifficulty.length - d) {
            int tmpDiff = helper(jobDifficulty, i + 1, d - 1);
            max = Math.max(max, jobDifficulty[i]);
            if (tmpDiff != -1 && tmpDiff + max < minDiff) {
                minDiff = tmpDiff + max;
            }
            i++;
        }

        dir[index][d] = minDiff;
        return minDiff;
    }
}
