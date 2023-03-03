package com.github.morningwn.t0501_t1000.t0501_t0600;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 反转字符串中的单词 III
 *
 * @author morningwn
 * @date 2020/8/30  9:53
 */
public class T0557 {

    @Test
    public void test() {
        String s = "Let's take LeetCode contest";
        Out.println(reverseWords(s));
    }

    public String reverseWords(String s) {

        char[] words = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int index = 0;
        int rev = 0;

        while (index < words.length) {

            if (words[index] == ' ') {
                sb.append(words[index]);
                index++;
                rev = index;
            } else {
                sb.insert(rev, words[index]);
                index++;
            }
        }

        return sb.toString();
    }

    public String reverseWords1(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            char[] tmp = words[i].toCharArray();

            for (int j = tmp.length - 1; j >= 0; j--) {
                sb.append(tmp[j]);
            }
            if (i < words.length - 1) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }
}
