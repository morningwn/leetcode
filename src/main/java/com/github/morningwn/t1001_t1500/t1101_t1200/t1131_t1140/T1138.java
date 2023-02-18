package com.github.morningwn.t1001_t1500.t1101_t1200.t1131_t1140;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/alphabet-board-path/"></a>
 *
 * @author morningwn
 * @create in 2023/2/12 22:26
 */
public class T1138 {

    @Test
    public void test() {
        System.out.println(alphabetBoardPath("zdz"));
    }

    private final char[][] board = {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'j'},
            {'k', 'l', 'm', 'n', 'o'},
            {'p', 'q', 'r', 's', 't'},
            {'u', 'v', 'w', 'x', 'y'},
            {'z'}
    };

    private final int[] boardL = {6, 5, 5, 5, 5};
    public String alphabetBoardPath(String target) {
        Map<Character, int[]> dictionary = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dictionary.put(board[i][j], new int[]{i, j});
            }
        }

        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        char pre = ' ';

        for (char c : target.toCharArray()) {
            int[] point = dictionary.get(c);
            if (pre !='z' && c != 'z') {
                sb.append(getPath(x, y, point[0], point[1]));
            } else {
                sb.append(getZPath(x, y, point[0], point[1], c));
            }
            pre = c;
            x = point[0];
            y = point[1];
        }
        return sb.toString();
    }

    /**
     * 如果方格存在，'U' 意味着将我们的位置上移一行；
     * 如果方格存在，'D' 意味着将我们的位置下移一行；
     * 如果方格存在，'L' 意味着将我们的位置左移一列；
     * 如果方格存在，'R' 意味着将我们的位置右移一列；
     *
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @return
     */
    private String getPath(int fromX, int fromY, int toX, int toY) {
        StringBuilder sb = new StringBuilder();
        if (fromX > toX) {
            sb.append("U".repeat(Math.max(0, fromX - toX)));
        } else if (fromX < toX) {
            sb.append("D".repeat(Math.max(0, toX - fromX)));
        }

        if (fromY > toY) {
            sb.append("L".repeat(Math.max(0, fromY - toY)));
        } else if (fromY < toY) {
            sb.append("R".repeat(Math.max(0, toY - fromY)));
        }

        sb.append('!');
        return sb.toString();
    }

    private String getZPath(int x, int y, int toX, int toY, char target) {
        //"DDDDD!
        // UUUUURRR!
        // DDDDLLLD!"
        StringBuilder sb = new StringBuilder();
        while (board[x][y] != target) {
            if (x > 0 && x > toX) {
                x--;
                sb.append("U");
                continue;
            } else if (x + 1 < boardL[y] && x < toX) {
                x++;
                sb.append("D");
                continue;
            }

            if (y > 0 && y > toY) {
                y--;
                sb.append("L");
            } else if (y + 1 < board[x].length && y < toY) {
                y++;
                sb.append("R");
            }
        }

        sb.append('!');
        return sb.toString();
    }
}
