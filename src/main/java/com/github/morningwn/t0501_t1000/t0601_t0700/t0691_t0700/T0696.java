package com.github.morningwn.t0501_t1000.t0601_t0700.t0691_t0700;

import com.github.morningwn.prefab.Out;
import org.junit.Test;


/**
 * <a href="https://leetcode.cn/problems/count-binary-substrings/">696. 计数二进制子串</a>
 *
 * @author morningwn
 * @date Created in 2020/8/10 10:54
 */
public class T0696 {

    @Test
    public void test() {
        String s = "00110011";
        Out.println(countBinarySubstrings(s));
    }

    /**
     * 遍历整个字符串，保存之前连续0/1的个数
     *
     * @param s 一个只有01的字符串
     * @return 结果
     */
    public int countBinarySubstrings(String s) {
        int res = 0;
        int pre = 0;
        int cur = 0;
        char flag = '-';

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == flag) {
                cur++;
            } else {
                res += Math.min(pre, cur);
                pre = cur;
                cur = 1;
                flag = s.charAt(i);
            }
        }

        res += Math.min(cur, pre);
        return res;
    }
}
