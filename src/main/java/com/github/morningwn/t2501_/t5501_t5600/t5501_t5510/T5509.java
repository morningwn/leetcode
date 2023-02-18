package com.github.morningwn.t2501_.t5501_t5600.t5501_t5510;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author morningwn
 * @date 2020/9/6  11:02
 */
public class T5509 {

    @Test
    public void test() {

        //23
//        "bbbaaa"
//                [4,9,3,8,8,9]

        String s = "bbbaaa";
        int[] cost = {4, 9, 3, 8, 8, 9};

        Out.println(minCost(s, cost));

    }

    public int minCost(String s, int[] cost) {
        char[] chars = s.toCharArray();
        int sum = 0;
        int count = 0;

        for (int i = 0; i < chars.length; ) {
            int j = i + 1;
            sum += cost[i];

            while (j < chars.length && chars[j] == chars[i]) {
                sum += cost[j];
                j++;
            }

            Out.println(i + "\t " + j);
            if (i < j) {
                int[] tmp = Arrays.copyOfRange(cost, i, j);
                Arrays.sort(tmp);
                Out.println(tmp[tmp.length - 1]);
                count += tmp[tmp.length - 1];
            } else {
                count += cost[i];
            }

            i = j;
        }

        return sum - count;
    }
}
