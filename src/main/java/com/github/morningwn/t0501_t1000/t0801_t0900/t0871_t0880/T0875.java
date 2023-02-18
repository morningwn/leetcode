package com.github.morningwn.t0501_t1000.t0801_t0900.t0871_t0880;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/koko-eating-bananas/">875. 爱吃香蕉的珂珂</a>
 *
 * @author moringwn
 * @create in 2022/6/7 9:55
 */
public class T0875 {

    @Test
    public void test() {
//        int[] piles = {3, 6, 7, 11};
//        Out.println(minEatingSpeed(piles, 8));

//        int[] piles = {30,11,23,4,20};
//        Out.println(minEatingSpeed(piles, 5));

        int[] piles = {30, 11, 23, 4, 20};
        Out.println(minEatingSpeed(piles, 6));

    }

    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        int k = 0;
        while (max >= min) {
            int m = (max + min) / 2;

            if (getTime(piles, m) <= h) {
                max = m - 1;
                k = m;
            } else {
                min = m + 1;
            }
        }
        return k;
    }

    private int getTime(int[] piles, int k) {
        int t = 0;

        for (int pile : piles) {
            t += (pile + k - 1) / k;
        }
        return t;
    }

}
