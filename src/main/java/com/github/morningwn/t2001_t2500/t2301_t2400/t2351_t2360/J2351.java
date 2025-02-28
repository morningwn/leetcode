package com.github.morningwn.t2001_t2500.t2301_t2400.t2351_t2360;

/**
 * <a href="https://leetcode.cn/problems/first-letter-to-appear-twice/">2351. 第一个出现两次的字母</a>
 *
 * @author morningwn
 * @create in 2023/1/1 11:09
 */
public class J2351 {

    public char repeatedCharacter(String s) {
        boolean[] flags = new boolean[27];

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (flags[c - 'a']) {
                return c;
            } else {
                flags[c - 'a'] = true;
            }
        }

        return ' ';
    }
}
