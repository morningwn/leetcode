package com.github.morningwn.t1001_t1500.t1401_t1500.t1421_t1430;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/maximum-score-after-splitting-a-string/">1422. 分割字符串的最大得分</a>
 *
 * @author morningwn
 * @create in 2022/8/4 16:07
 */
public class T1422 {

    @Test
    public void test() {
        String s = "011101";
        Out.println(maxScore(s));
    }

    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length + 1;
        int[] zeroCount = new int[length];
        int[] oneCount = new int[length];

        for (int i = 1, j = length - 2; i < length; i++, j--) {
            boolean zeroFlag = chars[i - 1] == '0';
            zeroCount[i] = zeroCount[i - 1] + (zeroFlag ? 1 : 0);
            boolean oneFlag = chars[j] == '1';
            oneCount[j] = oneCount[j + 1] + (oneFlag ? 1 : 0);
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (zeroCount[i] + oneCount[i] > max) {
                max = zeroCount[i] + oneCount[i];
            }
        }

        return max;
    }
}
