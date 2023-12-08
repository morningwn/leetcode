package com.github.morningwn.t2001_t2500.t2001_t2100.t2001_t2010;

import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.*;


/**
 * <a href="https://leetcode.cn/problems/maximum-earnings-from-taxi/">2008. 出租车的最大盈利</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#Array}</li>
 * <li>{@link Topic#BinarySearch}</li>
 * <li>{@link Topic#DynamicProgramming}</li>
 * <li>{@link Topic#Sorting}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-12-08 19:40:59
 */
public class J2008 {

    @Test
    public void test() {

    }


    public long maxTaxiEarnings(int n, int[][] rides) {
        Map<Integer, List<int[]>> rideMap = new HashMap<>();
        for (int[] ride : rides) {
            rideMap.computeIfAbsent(ride[1], k -> new ArrayList<>()).add(ride);
        }
        long[] earnings = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            List<int[]> rideList = rideMap.get(i);
            earnings[i] = earnings[i - 1];
            if (rideList != null) {
                for (int[] ride : rideList) {
                    earnings[i] = Math.max(earnings[i], ride[1] - ride[0] + ride[2] + earnings[ride[0]]);
                }
            }
        }

        return earnings[n];
    }
}
