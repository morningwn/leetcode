package com.github.morningwn.t0001_t0500.t0001_t0100.t0001_t0010;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/regular-expression-matching/">10. 正则表达式匹配</a>
 *
 * @author morningwn
 * @date
 */
public class T0010 {

    @Test
    public void test() {
        Out.println(isMatch("aab", "aab"));                //true
        Out.println(isMatch("aa", "a"));                    //false
        Out.println(isMatch("mississippi", "mis*is*p*."));    //false
        Out.println(isMatch("aaa", "ab*a*c*a"));            //true
        Out.println(isMatch("ab", ".*c"));                    //false
        Out.println(isMatch("a", "ab*"));                    //true
        Out.println(isMatch("bbbba", ".*a*a"));            //true
        Out.println(isMatch("a", ".*..a*"));                //false
        Out.println(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));                //false

    }

    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        } else if (p.length() > 0 && s.length() > 0) {
            if (p.length() >= 2 && p.charAt(1) == '*') {
                if (s.length() > 0) {
                    return (((s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.') &&
                            (isMatch(s.substring(1), p.substring(2)) || isMatch(s.substring(1), p))) ||
                            isMatch(s, p.substring(2));
                } else {
                    return false;
                }
            } else {
                return ((s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
            }
        } else if (s.length() == 0 && p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2));
        } else {
            return false;
        }

    }

    public boolean isMatch2(String s, String p) {

        int sl = s.length();
        int pl = p.length();
        int i = 0;
        int j = 0;

        while (i < sl && j < pl) {

            if (j < pl - 1 && p.charAt(j + 1) == '*') {
                char temp = p.charAt(j++);
                if (temp != '.') {
                    while (i < sl && s.charAt(i) == temp) {
                        i++;
                    }
                    while (j < pl - 1 && temp == p.charAt(j + 1)) {
                        j++;
                    }
                    j++;
                } else {
                }

            } else if (p.charAt(j) == '.') {
                i++;
                j++;
            } else if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        Out.println(i + "\t" + j);
        while (i == sl - 1 && j < pl - 1 && p.charAt(j) == '*') {
            j += 2;
        }

        return i == sl && j == pl;

    }

    public boolean isMatch1(String s, String p) {

        int i = s.length() - 1;
        int j = p.length() - 1;

        while (i >= 0 && j >= 0) {
            //Out.println( s.charAt(i) + "\t" + p.charAt(j) );
            if (p.charAt(j) == '*') {

                j--;
                if (p.charAt(j) != '.') {
                    while (i >= 0) {
                        if (s.charAt(i) == p.charAt(j)) {
                            i--;
                        } else {
                            break;
                        }
                    }
                    while (j > 0) {
                        if (p.charAt(j) == p.charAt(j - 1)) {
                            j--;
                        } else {
                            break;
                        }
                    }
                    j--;
                } else {
                    return true;
                }

            } else if (p.charAt(j) == '.') {
                i--;
                j--;
            } else if (s.charAt(i) == p.charAt(j)) {
                i--;
                j--;
            } else {
                return false;
            }
        }

        while (j >= 0) {
            if (p.charAt(j) == '*') {
                j -= 2;
            } else {
                break;
            }
        }
        //Out.println( i + "\t" + j );
        return i == -1 && j == -1;

    }

}
