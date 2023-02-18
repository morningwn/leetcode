package com.github.morningwn.t0501_t1000.t0501_t0600.t0521_t0530;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * 扫雷游戏
 *
 * @author morningwn
 * @version 1.0
 * @date Created in 2020-08-20 22:29
 */
public class T0529 {

    @Test
    public void test() {
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'M', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'M', 'E', 'E', 'E', 'E'}};

        int[] click = {3, 3};

        board = updateBoard(board, click);

        for (char[] b : board) {
            Out.println(Arrays.toString(b));
        }

        Out.println();
        board = updateBoard1(board, click);

        for (char[] b : board) {
            Out.println(Arrays.toString(b));
        }
    }

    /**
     * 递归调用方法，得到结果
     *
     * @param board 布局
     * @param click 点击的位置
     * @return 返回结果
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        helper(board, click[0], click[1]);

        return board;
    }

    /**
     * 递归算法辅助类
     *
     * @param board 布局
     * @param i     点击的位置
     * @param j     点击的位置
     */
    private void helper(char[][] board, int i, int j) {
        if (i >= board.length || i < 0 || j < 0 || j >= board[i].length) {
            return;
        }

        if (board[i][j] == 'M') {
            board[i][j] = 'X';
        } else if (board[i][j] == 'E') {
            int count = 0;

            //扫描四周，得到周围有几个雷
            for (int m = -1; m < 2; m++) {
                for (int n = -1; n < 2; n++) {
                    if (i + m >= 0 && i + m < board.length && j + n >= 0 && j + n < board[i].length) {
                        if (board[i + m][j + n] == 'M') {
                            count++;
                        }
                    }
                }
            }
            //只有在四周没有雷的情况下才可以继续进行四周的迭代
            if (count == 0) {
                board[i][j] = 'B';
                for (int m = -1; m < 2; m++) {
                    for (int n = -1; n < 2; n++) {
                        helper(board, i + m, j + n);

                    }
                }
                //如果四周有雷，就做标记然后结束
            } else if (count > 0) {
                board[i][j] = (char) ('0' + count);
            }
        }
    }

    /**
     * 迭代的去多次遍历数组
     *
     * @param board 排版
     * @param click 点击位置
     * @return 结果
     */
    public char[][] updateBoard1(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        } else {
            int res = 0;
            for (int m = -1; m < 2; m++) {
                for (int n = -1; n < 2; n++) {
                    if (click[0] + m >= 0 && click[0] + m < board.length && click[1] + n >= 0 && click[1] + n < board[click[0]].length) {
                        if (board[click[0] + m][click[1] + n] == 'M') {
                            res++;
                        }
                    }
                }
            }
            if (res == 0) {
                board[click[0]][click[1]] = 'B';
            } else {
                board[click[0]][click[1]] = (char) ('0' + res);
            }
        }

        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'E') {
                        int tmp = getMine(board, i, j);

                        if (tmp == 0) {
                            board[i][j] = 'B';
                            flag = true;
                        } else if (tmp > 0) {
                            board[i][j] = (char) ('0' + tmp);
                        }
                    }
                }
            }

        }

        return board;
    }

    /**
     * 迭代法的辅助方法，帮助查询四周有几个地雷
     *
     * @param board 面板
     * @param i     点击位置
     * @param j     点击位置
     * @return 个数
     */
    private int getMine(char[][] board, int i, int j) {
        int res = 0;
        boolean flag = false;

        for (int m = -1; m < 2; m++) {
            for (int n = -1; n < 2; n++) {
                if (i + m >= 0 && i + m < board.length && j + n >= 0 && j + n < board[i].length) {
                    if (board[i + m][j + n] == 'M') {
                        res++;
                    }

                    if (board[i + m][j + n] == 'B') {
                        flag = true;
                    }
                }
            }
        }

        if (flag) {
            return res;
        } else {
            return -1;
        }
    }
}
