package com.github.morningwn.t0001_t0500.t0001_t0100.t0001_t0010;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 *
 * @author morningwn
 * @date 2020/4/30 16:19
 */
public class T0003 {

    @Test
    public void test() {
        Out.println(lengthOfLongestSubstring("aab"));
    }

    public int lengthOfLongestSubstring(String s) {

        List<Character> res = new LinkedList<>();
        char[] inputs = s.toCharArray();
        int max = 0;

        for (char input : inputs) {

            int tmp = res.indexOf(input);

            if (tmp == -1) {
                res.add(input);
                max = Math.max(max, res.size());
            } else {
                res = res.subList(tmp + 1, res.size());
                res.add(input);
            }

        }

        return max;
    }

    /**
     * 之前的版本
     *
     * @param s 一个字符串
     * @return 最长的不重复子串
     */
    public int lengthOfLongestSubstring2(String s) {

        int sl = s.length();
        int tl = 0;

        if (sl <= 1) {
            return sl;
        }

        for (int i = 0; i < sl; i++) {

            for (int j = 0; j < (sl > 128 ? sl - 127 : i + 1); j++) {

                String temp = s.substring(j, j + (sl > 128 ? 128 : sl) - i);
                tl = temp.length();

                for (int k = 0; k < tl; k++) {

                    if (temp.indexOf(temp.charAt(k), k + 1) != -1) {
                        break;
                    }
                    if (k == tl - 1) {
                        return tl;

                    }
                }
            }
        }

        return 0;
    }
}
