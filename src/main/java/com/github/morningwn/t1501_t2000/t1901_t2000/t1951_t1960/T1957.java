package com.github.morningwn.t1501_t2000.t1901_t2000.t1951_t1960;

/**
 * <a href="https://leetcode.cn/problems/delete-characters-to-make-fancy-string/">1957. 删除字符使字符串变好</a>
 *
 * @author morningwn
 * @date Created in 2023/3/5 19:55
 */
public class T1957 {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        char pre = ' ';
        for (char c : s.toCharArray()) {
            if (c == pre) {
                flag++;
            } else {
                flag = 0;
            }
            pre = c;
            if (flag < 2) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
