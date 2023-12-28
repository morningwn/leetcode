package com.github.morningwn.t2501_t3000.t2601_t2700.t2651_t2660;

import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;


/**
 * <a href="https://leetcode.cn/problems/determine-the-winner-of-a-bowling-game/">2660. 保龄球游戏的获胜者</a>
 * <ul>
 * <li>{@link Difficulty#Easy}</li>
 * <li>{@link Topic#Array}</li>
 * <li>{@link Topic#Simulation}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-12-27 10:29:36
 */
public class J2660 {

    public int isWinner(int[] player1, int[] player2) {
        int score1 = getScore(player1);
        int score2 = getScore(player2);
        if (score1 > score2) {
            return 1;
        } else if (score1 == score2) {
            return 0;
        } else {
            return 2;
        }
    }

    private int getScore(int[] player) {
        int doubleScoreFlag = 0;
        int score = 0;
        for (int x : player) {
            if (doubleScoreFlag != 0) {
                score += 2 * x;
                doubleScoreFlag--;
            } else {
                score += x;
            }
            if (x == 10) {
                doubleScoreFlag = 2;
            }
        }
        return score;
    }
}
