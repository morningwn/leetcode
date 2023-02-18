package com.github.morningwn.t1501_t2000.t1801_t1900;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/truncate-sentence/">1816. 截断句子</a>
 *
 * @author morningwn
 * @date Created in 2021/12/6 10:39
 */
public class T1816 {

    @Test
    public void test() {
        String s = "hello how are you Contestant";
        int k = 4;
        Out.println(truncateSentence(s, k));
    }

    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == ' ' && ++count >= k) {
                break;
            }
            sb.append(tmp);
        }

        return sb.toString();
    }
}
