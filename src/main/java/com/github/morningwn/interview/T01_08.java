package com.github.morningwn.interview;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/zero-matrix-lcci/">面试题 01.08. 零矩阵</a>
 *
 * @author morningwn
 * @create in 2022/9/30 9:38
 */
public class T01_08 {

    @Test
    public void test() {
        int[][] matrix = {{0, 1, 0}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        Out.println(matrix);
    }

    public void setZeroes(int[][] matrix) {
        long maskM = 0;
        long maskN = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    maskM |= 1L << i;
                    maskN |= 1L << j;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ((maskM & (1L << i)) != 0 || (maskN & (1L << j)) != 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
