package com.github.morningwn.to_offer.t011_t020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/7/2 20:28
 */
public class T0012 {

    private char[][] board;
    private char[] words;
    private int m;
    private int n;
    private int len;

    @Test
    public void test() {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";

        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        String word = "bfce";

        Out.println(exist(board, word));
    }

    /**
     * @author morningwn
     * @date 2020/7/3 12:23
     * @description: 深度优先遍历
     * @param: board 一个包含字母的矩阵
     * @param: word 字符串
     * @return: boolean 判断结果
     */
    public boolean exist(char[][] board, String word) {
        this.board = board;
        words = word.toCharArray();
        m = board.length;
        n = board[0].length;
        len = word.length();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = helper(0, i, j);
                if (res) {
                    return res;
                }
            }
        }
        return false;
    }

    /**
     * @author morningwn
     * @date 2020/7/3 12:23
     * @description: 深度优先搜索
     * @param: index 在字母中的索引
     * @param: i 棋盘索引1
     * @param: j 棋盘索引2
     * @return: boolean 判断结果
     */
    private boolean helper(int index, int i, int j) {
        if (index >= len) {
            return true;
        }
        if (i >= m || j >= n || i < 0 || j < 0) {
            return false;
        }

        if (board[i][j] == words[index]) {
            boolean res = false;
            char tmp = board[i][j];
            board[i][j] = '/';
            res = helper(index + 1, i - 1, j) || helper(index + 1, i + 1, j) ||
                    helper(index + 1, i, j - 1) || helper(index + 1, i, j + 1);
            board[i][j] = tmp;
            return res;
        } else {
            return false;
        }
    }

}
