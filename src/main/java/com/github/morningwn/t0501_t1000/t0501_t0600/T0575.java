package com.github.morningwn.t0501_t1000.t0501_t0600;

import java.util.HashSet;
import java.util.Set;


public class T0575 {

    public int distributeCandies(int[] candies) {

        Set<Integer> set = new HashSet<>();

        for (int candy : candies) {
            set.add(candy);
        }

        if (set.size() > candies.length / 2) {
            return candies.length / 2;
        } else {
            return set.size();
        }
    }
}
