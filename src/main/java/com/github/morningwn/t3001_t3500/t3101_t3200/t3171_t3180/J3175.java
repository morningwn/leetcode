package com.github.morningwn.t3001_t3500.t3101_t3200.t3171_t3180;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.github.morningwn.prefab.Out;

/**
 * <a href="https://leetcode.cn/problems/find-the-first-player-to-win-k-games-in-a-row">3175. 找到连续赢 K 场比赛的第一位玩家</a>
 * 
 * @author morningwn
 * @date 2024-10-24 11:11:24
 */
public class J3175 {

    @Test
    public void test() {
        int[] skills = new int[0];

        skills = new int[] { 4, 2, 6, 3, 9 };
        Assert.assertEquals(4, findWinningPlayer(skills, 1000000000));

        // buildCase();
    }

    private void buildCase() {
        int[] skills = new int[100000];
        for (int i = 0; i < skills.length; i++) {
            skills[i] = i + 1;
        }
        Random random = new Random();
        for (int i = 0; i < skills.length * 1000; i++) {
            int nextInt1 = random.nextInt(skills.length);
            int nextInt2 = random.nextInt(skills.length);
            int tmp = skills[nextInt1];
            skills[nextInt1] = skills[nextInt2];
            skills[nextInt2] = tmp;
        }

        Out.toFile("/Users/mac/IdeaProjects/leetcode/target/1.json", skills);
    }

    public int findWinningPlayer(int[] skills, int k) {
        int[] winningCount = new int[skills.length];
        int winningIndex = 0;
        for (int i = 1; i < skills.length; i++) {
            if (skills[winningIndex] < skills[i]) {
                winningIndex = i;
            }
            winningCount[winningIndex]++;
            if (winningCount[winningIndex] >= k) {
                return winningIndex;
            }
        }
        return winningIndex;
    }

}
