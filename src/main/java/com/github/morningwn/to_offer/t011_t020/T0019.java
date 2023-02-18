package com.github.morningwn.to_offer.t011_t020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author morningwn
 * @date Created in 2020/7/5 21:23
 */
public class T0019 {

    @Test
    public void test() {
        String s = "";
        String p = "";
//        s = "";
//        p = "a*a*";

//        s = "aaa";
//        p = "ab*ac*a";

        s = "mississippi";
        p = "mis*is*p*.";

        s = "aab";
        p = "c*a*b";

        s = "aaaaaaaaaaaaab";
        p = "a*a*a*a*a*a*a*a*a*a*c";

//        s = "ab";
//        p = ".*..a*";

        s = "bbbba";
        p = ".*a*a";

        s = "a";
        p = "ac";
        Out.println(isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] mark = new boolean[sLen + 2][pLen + 2];
        mark[0][0] = true;
        //给判断结果的标记做预处理
        for (int i = 1; i < pLen; i += 2) {
            if (p.charAt(i) == '*') {
                mark[0][i] = true;
                mark[0][i + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char tmp = p.charAt(j - 1);

                if (tmp == '*') {
                    mark[i][j] = ((mark[i - 1][j - 1] || mark[i - 1][j]) && characterEq(s.charAt(i - 1), p.charAt(j - 2)))
                            || mark[i][j - 2];
                } else {
                    mark[i][j] = characterEq(s.charAt(i - 1), tmp) && mark[i - 1][j - 1];
                }

                Out.println(s.charAt(i - 1) + "\t " + tmp + "\t " + mark[i][j]);
            }
        }

        for (boolean[] m : mark) {
            Out.println(Arrays.toString(m));
        }
        return mark[sLen][pLen];
    }

    public boolean characterEq(char s, char p) {
        if (p == '.') {
            return true;
        } else {
            return p == s;
        }
    }

}
