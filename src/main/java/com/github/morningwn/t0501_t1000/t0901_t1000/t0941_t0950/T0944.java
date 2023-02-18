package com.github.morningwn.t0501_t1000.t0901_t1000.t0941_t0950;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/delete-columns-to-make-sorted/">944. 删列造序</a>
 *
 * @author moringwn
 * @create in 2022/5/12 10:36
 */
public class T0944 {

    @Test
    public void test() {
        String[] strs = {"cba"};

        Out.println(minDeletionSize(strs));
    }

    public int minDeletionSize(String[] strs) {
        int length = strs[0].length();
        int n = strs.length;
        int count = 0;

        for (int i = 0; i < length; i++) {
            char cur = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                char tmp = strs[j].charAt(i);
                if (tmp < cur) {
                    count++;
                    break;
                } else {
                    cur = tmp;
                }
            }
        }

        return count;
    }
}
