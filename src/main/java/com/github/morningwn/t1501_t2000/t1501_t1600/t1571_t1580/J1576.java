package com.github.morningwn.t1501_t2000.t1501_t1600.t1571_t1580;

/**
 * <a href="https://leetcode.cn/problems/replace-all-s-to-avoid-consecutive-repeating-characters/">1576. 替换所有的问号</a>
 *
 * @author morningwn
 * @date 2020/9/6  10:31
 */
public class J1576 {

    public String modifyString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {

                if (i > 0) {
                    if (i < chars.length - 1) {
                        chars[i] = choose(chars[i - 1], chars[i + 1]);
                    } else {
                        chars[i] = choose(chars[i - 1], ' ');
                    }
                } else {
                    if (i < chars.length - 1) {
                        chars[i] = choose(' ', chars[i + 1]);
                    } else {
                        chars[i] = choose(' ', ' ');
                    }
                }
            }
        }

        return String.valueOf(chars);
    }

    public char choose(char a, char b) {
        for (int i = 0; i < 27; i++) {
            char tmp = (char) ('a' + i);
            if (tmp != a && tmp != b) {
                return tmp;
            }
        }

        return ' ';
    }
}
