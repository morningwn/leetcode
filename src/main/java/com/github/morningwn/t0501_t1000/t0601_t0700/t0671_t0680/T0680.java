package com.github.morningwn.t0501_t1000.t0601_t0700.t0671_t0680;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome-ii/">680. 验证回文字符串 Ⅱ</a>
 *
 * @author morningwn
 * @date Created in 2020/5/19 10:07
 */
public class T0680 {
    @Test
    public void test() {
        Out.println(validPalindrome("aabdeenddbaagbddeedbaa"));//false
//        Out.println(validPalindrome( "ebcbbececabbacecbbcbe"));//true
//        Out.println(validPalindrome( "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));//false
//        Out.println(validPalindrome( "abca"));//false

    }

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();

        int l = 0, r = chars.length - 1;
        boolean res = true;
        while (l < r) {
            if (chars[l] == chars[r]) {
                l++;
                r--;
            } else {
                res = false;
                if (l < r && chars[l + 1] == chars[r]) {
                    res = true;

                    int tl = l + 1, tr = r;
                    while (tl < tr) {
                        if (chars[tl++] != chars[tr--]) {
                            res = false;
                            break;
                        }
                    }
                }
                if (r > l && chars[l] == chars[r - 1] && !res) {
                    int tl = l, tr = r - 1;
                    res = true;
                    while (tl < tr) {
                        if (chars[tl++] != chars[tr--]) {
                            res = false;
                            break;
                        }
                    }
                }
                return res;
            }
        }

        return res;
    }

}
