package com.github.morningwn.t0001_t0500.t0001_t0100.t0051_t0060;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date
 */
public class T0059 {

    @Test
    public void test() {

        for (int[] l : generateMatrix(6)) {
            for (int i : l) {
                Out.print(i + "\t ");
            }

            Out.println();
        }

    }

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int i = 0, j = 0;        //索引
        int count = 1;          //第几个数字
        int border = 0;         //记录当前行的边框有多厚

        while (border <= n / 2) {

            //从左向右
            for (; j < n - border; j++) {
                matrix[i][j] = count++;
            }
            j--;
            i++;

            //从上到下
            for (; i < n - border; i++) {
                matrix[i][j] = count++;
            }
            i--;
            j--;

            //从右到左
            for (; j >= border; j--) {
                matrix[i][j] = count++;
            }
            i--;
            j++;

            //在这个位置，接下来的边框的宽度需要再加一
            border++;

            //从下往上
            for (; i >= border; i--) {
                matrix[i][j] = count++;
            }
            i++;
            j++;

        }

        return matrix;

    }

}
