package com.github.morningwn.t1001_t1500.t1401_t1500.t1451_t1460;

/**
 * <a href="https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/">1455. 检查单词是否为句中其他单词的前缀</a>
 *
 * @author morningwn
 * @create in 2022/8/4 16:31
 */
public class J1455 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        char[] letters = sentence.toCharArray();
        char[] chars = searchWord.toCharArray();

        int i = 0;
        int j = 0;
        int index = 1;
        boolean flag = true;

        while (i < letters.length) {
            if (flag && letters[i] == chars[j]) {
                j++;
            } else {
                flag = false;
                j = 0;
            }
            if (j >= chars.length) {
                break;
            }
            if (letters[i] == ' ') {
                index++;
                flag = true;
            }
            i++;
        }

        if (j == chars.length) {
            return index;
        } else {
            return -1;
        }
    }
}
