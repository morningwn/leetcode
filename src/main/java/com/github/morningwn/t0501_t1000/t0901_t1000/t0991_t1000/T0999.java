package com.github.morningwn.t0501_t1000.t0901_t1000.t0991_t1000;


public class T0999 {

    public int numRookCaptures(char[][] board) {

        //遍历，找到车的位置
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                //如果这个位置是车的话
                if (board[i][j] == 'R') {
                    int num = 0;        //存储能吃到几个卒

                    //查找上下左右四个方向上，有那个能直接吃到
                    for (int k = i; k >= 0; k--) {

                        //如果遇到象了，被挡道了，直接结束循环
                        if (board[k][j] == 'B') {
                            break;
                        } else if (board[k][j] == 'p') {
                            num++;
                            break;
                        }
                    }
                    for (int k = i; k < 8; k++) {
                        if (board[k][j] == 'B') {
                            break;
                        } else if (board[k][j] == 'p') {
                            num++;
                            break;
                        }
                    }
                    for (int k = j; k >= 0; k--) {
                        if (board[i][k] == 'B') {
                            break;
                        } else if (board[i][k] == 'p') {
                            num++;
                            break;
                        }
                    }
                    for (int k = j; k < 8; k++) {
                        if (board[i][k] == 'B') {
                            break;
                        } else if (board[i][k] == 'p') {
                            num++;
                            break;
                        }
                    }

                    return num;
                }
            }
        }

        return 0;
    }
}
