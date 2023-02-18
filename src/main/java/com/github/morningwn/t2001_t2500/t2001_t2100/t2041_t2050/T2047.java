package com.github.morningwn.t2001_t2500.t2001_t2100.t2041_t2050;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/number-of-valid-words-in-a-sentence/">2047.句子中的有效单词数</a>
 *
 * @author morningwn
 * @date 2022/01/28 上午11:59
 */
public class T2047 {

    @Test
    public void test() {
        // String sentence = "!this 1-s b8d!";
        String sentence = "alice and  bob are playing- stone-game10";

        Out.println(countValidWords(sentence));
    }

    public int countValidWords(String sentence) {
        char[] chars = sentence.toCharArray();

        int count = 0;
        int flag = -1;
        int check = 1;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                // 无动作
                if (check == 0) {
                    check = 1;
                }
            } else if (chars[i] == '-') {
                if (flag == -1 && i > 0 && i + 1 < chars.length && (chars[i - 1] >= 'a' && chars[i - 1] <= 'z') && (chars[i + 1] >= 'a' && chars[i + 1] <= 'z')) {
                    flag = 1;
                } else {
                    check = -1;
                }
            } else if (chars[i] == '!' || chars[i] == '.' || chars[i] == ',') {
                if (i + 1 == chars.length || (i + 1 < chars.length && chars[i + 1] == ' ')) {
                    if (check == 0) {
                        check = 1;
                    }
                } else {
                    check = -1;
                }
            } else if (chars[i] == ' ') {
                if (check == 1) {
                    ++count;
                }
                flag = -1;
                check = 0;
            } else {
                check = -1;
            }
        }

        if (check == 1) {
            ++count;
        }

        return count;

    }
}
