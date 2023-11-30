package com.github.morningwn.t1501_t2000.t1601_t1700.t1651_t1660;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;


/**
 * <a href="https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/">1653. 使字符串平衡的最少删除次数</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#Stack}</li>
 * <li>{@link Topic#String}</li>
 * <li>{@link Topic#DynamicProgramming}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-11-30 16:54:41
 */
public class J1653 {

    @Test
    public void test() {
        String s = "aaaababbaaaab";
        int i = minimumDeletions(s);
        Out.println(i);
    }

    public int minimumDeletions(String s) {
        int[] countA = new int[s.length()];
        int[] countB = new int[s.length()];
        char[] chars = s.toCharArray();
        countA[s.length() - 1] = chars[s.length() - 1] == 'a' ? 1 : 0;
        countB[0] = chars[0] == 'b' ? 1 : 0;

        for (int i = 1, j = s.length() - 2; i < chars.length; i++, j--) {
            countB[i] = countB[i - 1] + (chars[i] == 'b' ? 1 : 0);
            countA[j] = countA[j + 1] + (chars[j] == 'a' ? 1 : 0);
        }
        int minDeletionCount = s.length();

        for (int i = 0; i < chars.length; i++) {
            minDeletionCount = Math.min(minDeletionCount, countB[i] + countA[i] -1);
        }

        return minDeletionCount;
    }
}
