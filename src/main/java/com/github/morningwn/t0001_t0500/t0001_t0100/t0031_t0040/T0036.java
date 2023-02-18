package com.github.morningwn.t0001_t0500.t0001_t0100.t0031_t0040;

/**
 * 有效的数独
 *
 * @author moringwn
 * @date 2021/9/17 上午10:09
 */
public class T0036 {

    public boolean isValidSudoku(char[][] board) {

        // 行列判断
        for (int i = 0; i < board.length; i++) {
            boolean[] rowFlag = new boolean[9];
            boolean[] lenFlag = new boolean[9];

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (rowFlag[board[i][j] - '1']) {
                        return false;
                    } else {
                        rowFlag[board[i][j] - '1'] = true;
                    }
                }
                if (board[j][i] != '.') {
                    if (lenFlag[board[j][i] - '1']) {
                        return false;
                    } else {
                        lenFlag[board[j][i] - '1'] = true;
                    }
                }
            }
        }

        // 3*3小方格判断
        for (int i = 1; i < board.length; i += 3) {
            for (int j = 1; j < board.length; j += 3) {
                boolean[] flag = new boolean[9];

                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        if (board[i + k][j + l] != '.') {
                            if (flag[board[i + k][j + l] - '1']) {
                                return false;
                            } else {
                                flag[board[i + k][j + l] - '1'] = true;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
