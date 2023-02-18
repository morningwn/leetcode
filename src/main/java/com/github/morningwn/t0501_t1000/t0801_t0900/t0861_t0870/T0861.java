package com.github.morningwn.t0501_t1000.t0801_t0900.t0861_t0870;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/score-after-flipping-matrix/">861. 翻转矩阵后的得分</a>
 *
 * @author morningwn
 * @date 2020/12/7 8:58
 */
public class T0861 {

    @Test
    public void test() {
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};

        Out.println(matrixScore(A));

    }

    public int matrixScore(int[][] A) {
        int line = A.length;
        int column = A[0].length;

        for (int i = 0; i < line; i++) {
            if (A[i][0] == 0) {
                revLine(A, i);
            }
        }


        for (int i = 0; i < column; i++) {
            int count = 0;

            for (int j = 0; j < line; j++) {
                if (A[j][i] == 0) {
                    count++;
                }
            }

            if (count >= (line + 1) / 2) {
                revColumn(A, i);
            }
        }

        for (int[] ints : A) {
            Out.println(Arrays.toString(ints));
        }

        int res = 0;
        int bit = 1;

        for (int i = column - 1; i >= 0; i--) {

            for (int j = line - 1; j >= 0; j--) {
                if (A[j][i] == 1) {
                    res += bit;
                }
            }

            bit *= 2;
        }

        return res;
    }

    public void revLine(int[][] matrix, int line) {
        for (int i = 0; i < matrix[line].length; i++) {
            if (matrix[line][i] == 0) {
                matrix[line][i] = 1;
            } else {
                matrix[line][i] = 0;
            }
        }
    }

    public void revColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][column] == 0) {
                matrix[i][column] = 1;
            } else {
                matrix[i][column] = 0;
            }
        }
    }
}
