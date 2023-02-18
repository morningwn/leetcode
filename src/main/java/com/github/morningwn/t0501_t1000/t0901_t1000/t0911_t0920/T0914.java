package com.github.morningwn.t0501_t1000.t0901_t1000.t0911_t0920;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T0914 {

    @Test
    public void test() {

//        int[] deck = { 1,2,3,4,4,3,2,1 };       //true
//        int[] deck = {};       //false
//        int[] deck = {1,1,1,2,2,2,3,3};       //false
//        int[] deck = { 1,1,2,2,2,2 };       //true
//        int[] deck = {1};       //false
//        int[] deck = {1, 1};       //true
        int[] deck = {1, 1, 1, 1, 1, 0, 0, 0};       //false

        Out.println(hasGroupsSizeX(deck));
    }

    public boolean hasGroupsSizeX(int[] deck) {

        int[] counts = new int[10001];
        int maxcount = Integer.MIN_VALUE;

        for (int i : deck) {
            counts[i]++;
//            mincount = Math.min( counts[i], mincount );
            maxcount = Math.max(counts[i], maxcount);
        }

//        Out.println( mincount + "\t" + maxcount );
        if (maxcount < 2) {
            return false;
        } else {

            int group = 2;

            while (group <= maxcount) {
                int index = 0;
                for (; index < 10001; index++) {
                    if (counts[index] != 0 && counts[index] % group != 0) {
                        break;
                    }
                }
                if (index == 10001) {
                    return true;
                } else {
                    group++;
                }
            }

            return false;
        }

    }

}
