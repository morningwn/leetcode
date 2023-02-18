package com.github.morningwn.t0501_t1000.t0501_t0600.t0521_t0530;

/**
 * <a href="https://leetcode.cn/problems/longest-uncommon-subsequence-ii/">522. 最长特殊序列 II</a>
 *
 * @author morningwn
 * @create in 2022/6/27 15:48
 */
public class T0522 {

    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            boolean check = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public boolean isSubseq(String s, String t) {
        int ptS = 0, ptT = 0;
        while (ptS < s.length() && ptT < t.length()) {
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ++ptS;
            }
            ++ptT;
        }
        return ptS == s.length();
    }
}
