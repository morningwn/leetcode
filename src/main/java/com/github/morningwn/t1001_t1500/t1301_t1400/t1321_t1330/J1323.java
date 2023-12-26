package com.github.morningwn.t1001_t1500.t1301_t1400.t1321_t1330;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;


/**
 * <a href="https://leetcode.cn/problems/maximum-69-number/">1323. 6 和 9 组成的最大数字</a>
 * <ul>
 * <li>{@link Difficulty#Easy}</li>
 * <li>{@link Topic#Greedy}</li>
 * <li>{@link Topic#Math}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2020.01.28 21:09
 */
public class J1323 {

    @Test
    public void test() {

        Out.println(maximum69Number(699));           //999
        Out.println(maximum69Number(6));             //9
        Out.println(maximum69Number(9699));           //9999
        Out.println(maximum69Number(0));           //

    }

    public int maximum69Number(int num) {

        String input = num + "";

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '6') {
                return Integer.parseInt(input.substring(0, i) + "9" + input.substring(i + 1));
            }
        }

        return num;
    }
}
