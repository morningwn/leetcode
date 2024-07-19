package com.github.morningwn.t0001_t0500.t0001_t0100.t0051_t0060;

import org.junit.Test;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.cn/problems/n-queens-ii/">52. N 皇后 II</a>
 * 
 * @author morningwn
 * @date
 */
public class J0052 {

    @Test
    public void test() {

    }

    public int totalNQueens(int n) {
        int output = 0;
        int[][] seat = new int[n][n];
        ArrayList<Integer> heap = new ArrayList<>();

        int i = 0, j = 0;
        while (i < n && j <= n) {

            if (j == n) {
                i--;
                j = heap.get(i) + 1;
                heap.set(i, j);
            } else {
                if (check(seat)) {

                    if (i == n) {
                        output++;
                        i--;
                        j = 0;
                    } else {
                        seat[i][j] = 1;
                        i++;
                        j = 0;
                    }
                } else {
                    j++;
                }
            }
        }

        return output;
    }

    public boolean check(int[][] seat) {

        return true;

    }
}
