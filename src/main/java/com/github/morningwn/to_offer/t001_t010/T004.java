package com.github.morningwn.to_offer.t001_t010;

/**
 * @author morningwn
 * @description: 从一个二维已排序数组中查询结果
 * @date Created in 2020/6/30 16:41
 * @version: 1.0
 */
public class T004 {

    private int n;
    private int m;

    public T004() {

    }

    /**
     * @param matrix
     * @param target
     * @return boolean
     * @author morningwn
     * @date 2020/6/30 23:08
     * @description: 左下角标志数法
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;

        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * @param matrix 输入的已排序二维数组
     * @param target 查询目标
     * @return boolean
     * @author morningwn
     * @date 2020/6/30 23:01
     * @description: 二维的折半查询
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        } else {
            n = matrix.length;
            m = matrix[0].length;
        }
        return findNumEach(matrix, target, 0, 0, n, m);
    }

    /**
     * @return boolean
     * @author morningwn
     * @date 2020/6/30 23:04
     * @description:进行一次折半查询
     */
    public boolean findNumEach(int[][] matrix, int target, int starti, int startj, int endi, int endj) {
        if (starti > endi) {
            return false;
        }
        if (startj > endj) {
            return false;
        }

        int i = (starti + endi) / 2;
        int j = (startj + endj) / 2;

        //判断中间值是否已经越界
        if (i >= n || j >= m) {
            return false;
        }

        //等于目标值就返回true
        if (matrix[i][j] == target) {
            return true;
            //大于目标值就取前半部分
        } else if (matrix[i][j] > target) {
            return findNumEach(matrix, target, starti, startj, i - 1, endj) || findNumEach(matrix, target, starti, startj, endi, j - 1);
            //小于就取后半部分
        } else {
            return findNumEach(matrix, target, i + 1, startj, endi, endj) || findNumEach(matrix, target, starti, j + 1, endi, endj);
        }

    }
}
