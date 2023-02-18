package com.github.morningwn.t0001_t0500.t0001_t0100.t0041_t0050;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/7/5 9:32
 */
public class T0044 {

    @Test
    public void test() {
        String s = "a";
        String p = "a*";

        Out.println(isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {

        //初始化几种东西
        int slen = s.length();
        int plen = p.length();
        boolean[][] res = new boolean[slen + 2][plen + 2];

        //给判断结果的标记做预处理
        for (int i = plen - 1; i >= 0; i--) {
            if (p.charAt(i) == '*') {
                res[slen + 1][i + 1] = true;
            } else {
                break;
            }
        }
        res[0][0] = true;
        res[slen + 1][plen + 1] = true;

        //从后向前依次匹配得出结果
        for (int i = slen; i > 0; i--) {
            for (int j = plen; j > 0; j--) {
                char tmp = p.charAt(j - 1);
                if (tmp == '?') {
                    res[i][j] = res[i + 1][j + 1];
                } else if (tmp == '*') {
                    res[i][j] = res[i][j + 1] || res[i + 1][j + 1] || res[i + 1][j];
                } else {
                    res[i][j] = tmp == s.charAt(i - 1) && res[i + 1][j + 1];
                }
            }
        }

        return res[1][1];
    }

}
