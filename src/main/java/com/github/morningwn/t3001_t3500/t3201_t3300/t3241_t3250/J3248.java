package com.github.morningwn.t3001_t3500.t3201_t3300.t3241_t3250;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/snake-in-matrix/description">3248. 矩阵中的蛇</a>
 *
 * @author morningwn
 * @date 2024-11-21 18:29:24
 */
public class J3248 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;

        for (String command : commands) {
            switch (command) {
                case "UP" -> i--;
                case "DOWN" -> i++;
                case "LEFT" -> j--;
                case "RIGHT" -> j++;
            }
        }

        return i * n + j;
    }
}