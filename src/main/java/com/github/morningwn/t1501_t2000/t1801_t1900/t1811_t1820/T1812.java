package com.github.morningwn.t1501_t2000.t1801_t1900;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/determine-color-of-a-chessboard-square/">1812. 判断国际象棋棋盘中一个格子的颜色</a>
 *
 * @author morningwn
 * @date Created in 2022/12/09 10:12
 */
public class T1812 {

    @Test
    public void test() {
        Out.println('1' - '0');
        Out.print(squareIsWhite("f4"));
    }

    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) - 'a' + coordinates.charAt(1) - '0' + 1) % 2 == 1;
    }
}