package com.github.morningwn.t1001_t1500.t1401_t1500.t1431_t1440;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningwn
 * @description: 拥有最多糖果的孩子
 * @date Created in 2020/6/1 10:18
 * @version: 1.0
 */
public class T1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        List<Boolean> canBeMax = new ArrayList<>();

        for (int candy : candies) {
            if (candy > maxCandy) {
                maxCandy = candy;
            }
        }

        for (int candy : candies) {
            if (candy + extraCandies >= maxCandy) {
                canBeMax.add(true);
            } else {
                canBeMax.add(false);
            }
        }

        return canBeMax;
    }

}
