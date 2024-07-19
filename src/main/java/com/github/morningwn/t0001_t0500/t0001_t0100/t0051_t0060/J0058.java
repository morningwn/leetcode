package com.github.morningwn.t0001_t0500.t0001_t0100.t0051_t0060;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/length-of-last-word/">58. 最后一个单词的长度</a>
 *
 * @author morningwn
 * @date 2024/7/19  18:06
 */
public class J0058 {

    @Test
    public void test() {
        Assert.assertEquals(1, lengthOfLastWord(" a"));
        Assert.assertEquals(1, lengthOfLastWord("a"));
        Assert.assertEquals(1, lengthOfLastWord(" a"));
        Assert.assertEquals(1, lengthOfLastWord("a"));
        Assert.assertEquals(5, lengthOfLastWord("Hello World"));


    }

    public int lengthOfLastWord(String s) {
        int wordLength = 0;
        char[] charArray = s.toCharArray();

        for (int i = s.length() - 1; i > -1; i--) {
            if (charArray[i] == ' ') {
                if (wordLength != 0) {
                    return wordLength;
                }
                continue;
            }
            wordLength++;
        }

        return wordLength;
    }
}