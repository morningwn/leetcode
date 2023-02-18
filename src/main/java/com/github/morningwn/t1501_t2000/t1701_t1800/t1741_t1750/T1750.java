package com.github.morningwn.t1501_t2000.t1701_t1800.t1741_t1750;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/minimum-length-of-string-after-deleting-similar-ends/">1750. 删除字符串两端相同字符后的最短长度</a>
 *
 * @author morningwn
 * @create in 2022/12/28 15:22
 */
public class T1750 {

    @Test
    public void test() {
        String s = "cabaabac";
        Out.print(minimumLength(s));
    }

    public int minimumLength(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char flag = s.charAt(l);
            if (s.charAt(l) != flag || s.charAt(r) != flag) {
                break;
            }
            while (l <= r && s.charAt(l) == flag) {
                l++;
            }

            while (l <= r && s.charAt(r) == flag) {
                r--;
            }

            Out.println(s.substring(l, r + 1));
        }

        return r - l + 1;
    }
}
