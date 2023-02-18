package com.github.morningwn.t0001_t0500.t0001_t0100.t0031_t0040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author morningwn
 * @date 2020/9/15  18:38
 */
public class T0037 {


    private boolean flag;

    @Test
    public void test() {
        char[][] board = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};

        solveSudoku(board);

        for (char[] chara : board) {
            Out.println(Arrays.toString(chara));
        }
    }

    public void solveSudoku(char[][] board) {
        char[][] answer = new char[9][9];
        flag = false;
        helper(0, 0, board, answer);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (answer[i][j] != 0) {
                    board[i][j] = answer[i][j];
                }
            }
        }
    }

    public void helper(int i, int j, char[][] board, char[][] answer) {
        Out.println("i:" + i + "\t j:" + j);
        if (i >= 9) {
            flag = true;
            return;
        }

        if (board[i][j] != '.') {
            if (j < 8) {
                helper(i, j + 1, board, answer);
            } else {
                helper(i + 1, 0, board, answer);
            }
        }

        List<Character> nums = getCandidate(i, j, board, answer);
        if (nums.size() == 0) {
        } else {
            for (char num : nums) {
                answer[i][j] = num;
                if (j < 8) {
                    helper(i, j + 1, board, answer);
                } else {
                    helper(i + 1, 0, board, answer);
                }
                if (flag) {
                    return;
                } else {
                    answer[i][j] = 0;
                }
            }
        }
    }

    private List<Character> getCandidate(int i, int j, char[][] board, char[][] answer) {

        List<Character> res = new ArrayList<>();
        for (char k = '1'; k < 58; k++) {
            res.add(k);
        }

        for (int k = 0; k < 9; k++) {
            res.remove(Character.valueOf(board[i][k]));
            res.remove(Character.valueOf(board[k][j]));
            res.remove(Character.valueOf(answer[i][k]));
            res.remove(Character.valueOf(answer[k][j]));
        }
        int r = (i / 3) * 3 + 1;
        int c = (j / 3) * 3 + 1;

        for (int m = -1; m < 2; m++) {
            for (int n = -1; n < 2; n++) {
                res.remove(Character.valueOf(board[r + m][c + n]));
                res.remove(Character.valueOf(answer[r + m][c + n]));
            }
        }

        return res;
    }

}
