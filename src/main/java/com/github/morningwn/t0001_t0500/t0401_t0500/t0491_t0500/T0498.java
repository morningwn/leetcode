package com.github.morningwn.t0001_t0500.t0401_t0500.t0491_t0500;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/diagonal-traverse/">498. 对角线遍历</a>
 *
 * @author moringwn
 * @create in 2022/6/14 11:01
 */
public class T0498 {

    @Test
    public void test() {
//        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        int[][] mat = {{1, 2}};
        int[][] mat = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
//        int[][] mat = {{1},{2}};

        int[] diagonalOrder = findDiagonalOrder(mat);

        //[1,2,4,7,5,3,6,8,9]
        Out.println(Arrays.toString(diagonalOrder));
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int length = m * n;
        int[] result = new int[length];
        int index = 0;

        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0) {
                // ↗
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    result[index++] = mat[x--][y++];
                }
            } else {
                // ↙
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    result[index++] = mat[x++][y--];
                }
            }
        }

        return result;
    }
}
