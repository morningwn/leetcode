package com.github.morningwn.t1501_t2000.t1901_t2000.t1961_t1970;

/**
 * <a href="https://leetcode.cn/problems/number-of-strings-that-appear-as-substrings-in-word">1967. 作为子字符串出现在单词中的字符串数目</a>
 *
 * @author morningwn
 * @date 2026-06-29 18:50:09
 */
public class J1967 {

    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }
        return count;
    }
}
