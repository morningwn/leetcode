package com.github.morningwn.t2001_t2500.t2301_t2400.t2311_t2320;

/**
 * <a href="https://leetcode.cn/problems/count-asterisks/">2315. 统计星号</a>
 *
 * @author morningwn
 * @create in 2023/1/29 21:41
 */
public class J2315 {

    public int countAsterisks(String s) {
        int count = 0;
        boolean flag = false;
        int tmpCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                flag = !flag;
                if (flag) {
                    count += tmpCount;
                }
                tmpCount = 0;
            } else if (c == '*') {
                tmpCount++;
            }
        }

        count += tmpCount;
        return count;
    }
}
