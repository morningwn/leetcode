package com.github.morningwn.t1001_t1500.t1201_t1300.t1221_t1230;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/split-a-string-in-balanced-strings/">1221. 分割平衡字符串</a>
 *
 * @author moringwn
 * @date
 */
public class T1221 {

    @Test
    public void test() {

        Out.println(balancedStringSplit("RLRRLLRLRL"));    //4
        Out.println(balancedStringSplit("RLLLLRRRLR"));    //3
        Out.println(balancedStringSplit("LLLLRRRR"));    //1
        Out.println(balancedStringSplit("RLRRRLLRLL"));    //2
    }

    public int balancedStringSplit(String s) {

        int i = 0, j = 0, output = 0;
        for (int count = 0; count < s.length(); count++) {
            if (i == j) {
                i = 0;
                j = 0;
                output++;
            }

            if (s.charAt(count) == 'R') {
                i++;
            } else {
                j++;
            }
        }

        return output;
    }
}

