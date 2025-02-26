package com.github.morningwn.t1001_t1500.t1401_t1500.t1411_t1420;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/reformat-the-string/">1417. 重新格式化字符串</a>
 *
 * @author morningwn
 * @create in 2022/8/11 14:05
 */
public class J1417 {

    @Test
    public void test() {
        String s = "leetcode1234567891";

        Out.println(reformat(s));
    }

    public String reformat(String s) {
        char[] chars = s.toCharArray();
        char[] word = new char[chars.length];
        int cntLetter = 0;
        int cntDigit = 0;
        for (char aChar : chars) {
            if ('0' <= aChar && aChar <= '9') {
                cntDigit++;
            } else {
                cntLetter++;
            }
        }
        int indexD = 0;
        int indexL = 0;
        if (cntLetter == cntDigit) {
            indexD = 0;
            indexL = 1;
        } else if (cntLetter + 1 == cntDigit) {
            indexD = 0;
            indexL = 1;
        } else if (cntLetter == cntDigit + 1) {
            indexD = 1;
            indexL = 0;
        } else {
            return "";
        }
        for (char aChar : chars) {
            if ('0' <= aChar && aChar <= '9') {
                word[indexD] = aChar;
                indexD += 2;
            } else {
                word[indexL] = aChar;
                indexL += 2;
            }
        }

        return new String(word);
    }
}
