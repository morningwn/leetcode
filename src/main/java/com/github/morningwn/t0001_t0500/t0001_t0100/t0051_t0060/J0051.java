package com.github.morningwn.t0001_t0500.t0001_t0100.t0051_t0060;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-queens/description/">51. N 皇后</a>
 *
 * @author morningwn
 * @date 2020/9/3  10:20
 */
public class J0051 {

    private List<List<String>> res;
    private String board;

    @Test
    public void test() {
        Out.println(solveNQueens(4));
    }

    /**
     * 回溯方法得到所有结果
     *
     * @param n 棋盘大小
     * @return 所有结果
     */
    public List<List<String>> solveNQueens(int n) {
        //初始化结果集
        res = new ArrayList<>();

        //特色情况的处理
        if (n == 0) {
            return res;
        }

        //索引，标记每一行摆放的皇后的位置
        int[] map = new int[n];

        StringBuilder sb = new StringBuilder();

        //初始化索引，默认为-1
        for (int i = 0; i < n; i++) {
            map[i] = -1;
            sb.append('.');
        }
        board = sb.toString();
        //开始递归，找到所有的结果
        helper(0, 0, map);

        return res;
    }

    /**
     * 依次往下递归，找到所有的情况，如果没有就进行回溯
     *
     * @param board 棋盘
     * @param i     行索引
     * @param j     列索引
     * @param map   皇后摆放的位置，用于回溯的时候恢复现场
     */
    public void helper(int i, int j, int[] map) {

        //行索引小于零证明已经遍历了所有的情况，可以返回了
        if (i < 0) {
            return;
        }

        //列索引越界，需要进行回溯，行号减一，并重置当前行的索引
        if (j >= map.length) {
            map[i] = -1;
            helper(i - 1, 0, map);
            return;
        }

        //行索引越界，需要得到一个结果了，将结果加入结果集，然后进行回溯
        if (i >= map.length) {
            Out.println(Arrays.toString(map));
            addRes(map);
            helper(i - 1, 0, map);
            return;
        }

        //如果当前行的标记为-1证明之前并没有进入过这一行，从0开始、
        //如果之前已经到过此处，证明是进行了回溯，那就恢复之前的现场，然后将列索引加一，进入下一次的循环
        if (map[i] == -1) {
            //检查当前位置是否能进行摆放
            //如果可以，进行标记，进入下一行
            //否则将列索引加一
            if (check(map, i, j)) {
//                board[i][j] = "Q";
                map[i] = j;
                helper(i + 1, 0, map);
            } else {
                helper(i, j + 1, map);
            }
        } else {
            j = map[i];
            map[i] = -1;
//            board[i][j] = ".";
            helper(i, j + 1, map);
        }
    }

    /**
     * 将结果加入结果集
     *
     * @param map 每行摆放的位置
     */
    public void addRes(int[] map) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            StringBuilder sb = new StringBuilder(board);
            sb.setCharAt(map[i], 'Q');
            list.add(sb.toString());
        }

        res.add(list);
    }

    public boolean check(int[] map, int i, int j) {
        if (map[i] != -1) {
            return false;
        }

        for (int index : map) {
            if (index == j) {
                return false;
            }
        }

        for (int m = 0; m < map.length; m++) {
            if (map[m] == -1) {
                break;
            }
            for (int n = 1; n < map.length; n++) {
                if (map[m] + n <= map.length && m + n == i && map[m] + n == j) {
                    return false;
                }
                if (map[m] - n <= map.length && m + n == i && map[m] - n == j) {
                    return false;
                }

                if (map[m] + n <= map.length && m - n == i && map[m] + n == j) {
                    return false;
                }
                if (map[m] - n <= map.length && m - n == i && map[m] - n == j) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 检查当前位置是否能够摆放皇后
     *
     * @param board 棋盘
     * @param i     行索引
     * @param j     列索引
     * @return 判断结果
     */
    public boolean check(String[][] board, int i, int j) {

        //对上下进行判断
        for (int m = 0; m < board.length; m++) {
            if ("Q".equals(board[i][m])) {
                return false;
            }
            if ("Q".equals(board[m][j])) {
                return false;
            }
        }

        //判断当前位置的左上方
        for (int m = 1; i - m >= 0 && j - m >= 0; m++) {
            if ("Q".equals(board[i - m][j - m])) {
                return false;
            }
        }

        //判断右下方
        for (int m = 1; i + m < board.length && j + m < board.length; m++) {
            if ("Q".equals(board[i + m][j + m])) {
                return false;
            }
        }

        //判断右上方
        for (int m = 1; i - m >= 0 && j + m < board.length; m++) {
            if ("Q".equals(board[i - m][j + m])) {
                return false;
            }
        }

        //判断左下方
        for (int m = 1; i + m < board.length && j - m >= 0; m++) {
            if ("Q".equals(board[i + m][j - m])) {
                return false;
            }
        }

        return true;
    }
}
