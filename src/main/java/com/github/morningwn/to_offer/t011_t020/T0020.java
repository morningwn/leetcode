package com.github.morningwn.to_offer.t011_t020;

import java.util.HashMap;
import java.util.Map;

/**
 * @author morningwn
 * @description: 表示数值的字符串
 * @date Created in 2020/7/5 23:05
 */
public class T0020 {

    /**
     * 有穷自动机
     *
     * @param s 字符串
     * @return 判断结果
     */
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Character, Integer>() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }},
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 4);
                }},
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                }},
                new HashMap<Character, Integer>() {{
                    put('s', 6);
                    put('d', 7);
                }},
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                }},
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                    put(' ', 8);
                }},
                new HashMap<Character, Integer>() {{
                    put(' ', 8);
                }}
        };

        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                t = 'd';
            } else if (c == '+' || c == '-') {
                t = 's';
            } else if (c == 'e' || c == 'E') {
                t = 'e';
            } else if (c == '.' || c == ' ') {
                t = c;
            } else {
                t = '?';
            }
            if (!states[p].containsKey(t)) {
                return false;
            }
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

    /**
     * 强行计算
     *
     * @param s 字符串
     * @return 是否是一个合法的字符串
     */
    public boolean isNumber1(String s) {

        for (char t : s.toCharArray()) {

            if (t < 48 || t > 57) {
                if (t != ' ' && t != 'e' && t != '.' && t != '+' && t != '-') {
                    return false;
                }
            }
        }
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
