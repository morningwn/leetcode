package com.github.morningwn.t3001_t3500.t3001_t3100.t3091_t3100;

/**
 * <a href="https://leetcode.cn/problems/minimum-levels-to-gain-more-points/description/">3096. 得到更多分数的最少关卡数目</a>
 *
 * @author morningwn
 * @date 2024/7/19 14:28
 */
public class J3096 {

    public int minimumLevels(int[] possible) {
        int total = 0;
        for (int i : possible) {
            total += i == 0 ? -1 : 1;
        }

        int alice = 0;
        int bob = total;
        int levelCount = 0;
        for (int i : possible) {
            if (i == 0) {
                alice -= 1;
                bob += 1;
            } else {
                alice += 1;
                bob -= 1;
            }
            levelCount++;
            if (alice > bob) {
                break;
            }
        }
        if (alice > bob && levelCount != possible.length) {
            return levelCount;
        }
        return -1;
    }
}