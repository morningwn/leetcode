package com.github.morningwn.t0001_t0500.t0101_t0200.t0111_t0120;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author morningwn
 * @date Created in 2020/7/14 10:10
 */
public class T0120 {

    @Test
    public void test() {

        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> line1 = new ArrayList<>();
        List<Integer> line2 = new ArrayList<>();
        List<Integer> line3 = new ArrayList<>();
        List<Integer> line4 = new ArrayList<>();

        line1.add(2);
        line2.add(3);
        line2.add(4);
        line3.add(6);
        line3.add(5);
        line3.add(7);
        line4.add(4);
        line4.add(1);
        line4.add(8);
        line4.add(3);

        triangle.add(line1);
        triangle.add(line2);
        triangle.add(line3);
        triangle.add(line4);

        Out.println(minimumTotal(triangle));
    }

    /**
     * @author morningwn
     * @date 2020/7/14 10:55
     * @description: 层次遍历，得到到达每个节点的最小值
     * @param: triangle
     * @return: int
     */
    private int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[][] num = new int[length][length];

        int min = Integer.MAX_VALUE;
        num[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < length; i++) {
            List<Integer> line = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if (j - 1 >= 0 && j < i) {
                    num[i][j] = Math.min(num[i - 1][j - 1], num[i - 1][j]) + line.get(j);
                } else if (j == i) {
                    num[i][j] = num[i - 1][j - 1] + line.get(j);
                } else if (j == 0) {
                    num[i][j] = num[i - 1][j] + line.get(j);
                } else {
                    num[i][j] = line.get(j);
                }
            }

            Out.println(Arrays.toString(num[i]));
        }

        for (int n : num[length - 1]) {
            min = Math.min(n, min);
        }
        return min;
    }

}
