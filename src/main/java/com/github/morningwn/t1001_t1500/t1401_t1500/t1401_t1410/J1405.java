package com.github.morningwn.t1001_t1500.t1401_t1500.t1401_t1410;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/longest-happy-string/">1405.最长快乐字符串</a>
 *
 * @author morningwn
 * @date 2022-02-07 09:57:12
 */
public class J1405 {

    @Test
    public void test() {
        int a = 1;
        int b = 1;
        int c = 7;

        Out.println(longestDiverseString(a, b, c));

    }

    public String longestDiverseString(int a, int b, int c) {

        StringBuilder sb = new StringBuilder(a + b + c);
        char flag = ' ';
        while (a > 0 || b > 0 || c > 0) {
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == 'a' && sb.charAt(length - 2) == 'a') {
                flag = 'a';
            } else if (length > 1 && sb.charAt(length - 1) == 'b' && sb.charAt(length - 2) == 'b') {
                flag = 'b';
            } else if (length > 1 && sb.charAt(length - 1) == 'c' && sb.charAt(length - 2) == 'c') {
                flag = 'c';
            } else {
                flag = ' ';
            }

            if (a > b && a > c && flag != 'a') {
                sb.append('a');
                a--;
            } else if (b > a && b > c && flag != 'b') {
                sb.append('b');
                b--;
            } else if (c > a && c > b && flag != 'c') {
                sb.append('c');
                c--;
            } else if (flag != 'a' && a > 0) {
                sb.append('a');
                a--;
            } else if (flag != 'b' && b > 0) {
                sb.append('b');
                b--;
            } else if (flag != 'c' && c > 0) {
                sb.append('c');
                c--;
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
