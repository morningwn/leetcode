package com.github.morningwn.to_offer.t021_t030;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author morningwn
 * @description: 顺时针打印矩阵
 * @date Created in 2020/7/8 18:17
 * @version: 1.0
 */
public class T0029 {

    @Test
    public void test() {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix = {{0}, {1}};
//        int[][] matrix = {{1,2},{2,3}};

        Out.println(Arrays.toString(spiralOrder(matrix)));
    }

    /**
     * @author morningwn
     * @date 2020/7/8 21:41
     * @description: 按层模拟去遍历整个矩阵得到结果进行输出
     * @param: matrix 矩阵
     * @return: int[] 遍历后的结果
     */
    public int[] spiralOrder(int[][] matrix) {
        int i = 0;
        int j = 0;
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int column = matrix[0].length;
        int[] res = new int[row * column];
        int index = 0;
        int sp = 0;

        while (index < res.length) {
            for (; j < column - sp && index < res.length; j++) {
                res[index++] = matrix[i][j];
            }
            j--;
            i++;
            for (; i < row - sp && index < res.length; i++) {
                res[index++] = matrix[i][j];
            }
            i--;
            j--;
            for (; j > sp && index < res.length; j--) {
                res[index++] = matrix[i][j];
            }
            sp++;

            for (; i > sp && index < res.length; i--) {
                res[index++] = matrix[i][j];
            }

        }

        return res;
    }

}
