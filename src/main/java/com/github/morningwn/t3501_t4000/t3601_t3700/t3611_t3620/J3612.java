package com.github.morningwn.t3501_t4000.t3601_t3700.t3611_t3620;

/**
 * <a href="https://leetcode.cn/problems/process-string-with-special-operations-i">3612. 用特殊操作处理字符串 I</a>
 *
 * @author morningwn
 * @date 2026-06-22 20:30
 */
public class J3612 {

    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (c == '#') {
                sb.append(sb);
            } else if (c == '%') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
