package com.github.morningwn.t2501_.t5401_t5500.t5451_t5460;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/7/5 11:07
 */
public class T5454 {

    private int rows;
    private int columns;

    @Test
    public void test() {

        int[][] mat = {{1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}};

        Out.println(numSubmat(mat));
    }

    public int numSubmat(int[][] mat) {
        rows = mat.length;
        columns = mat[0].length;
        int res = 0;

        for (int m = 0; m <= rows; m++) {
            for (int n = 0; n <= columns; n++) {
                for (int i = 1; i <= rows; i++) {
                    for (int j = 1; j <= columns; j++) {

                        if (check(mat, m, n, i, j)) {
                            res++;
                        } else {
                            break;
                        }
                        //Out.println(res + "\t " + i + "\t " + j + "\t m:" + m + "\t n:" + n);
                    }
                }
            }
        }

        return res;
    }

    public boolean check(int[][] matrix, int i, int j, int r, int c) {

        for (int m = 0; m < r; m++) {
            for (int n = 0; n < c; n++) {
                if (m + i >= rows || n + j >= columns || matrix[m + i][n + j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

}
