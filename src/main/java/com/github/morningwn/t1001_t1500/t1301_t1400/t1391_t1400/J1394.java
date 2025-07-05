package com.github.morningwn.t1001_t1500.t1301_t1400.t1391_t1400;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/find-lucky-integer-in-an-array">1394. 找出数组中的幸运数</a>
 *
 * @author morningwn
 * @date 2025/7/5 14:15
 */
public class J1394 {

    public int findLucky(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr) {
            Integer count = countMap.getOrDefault(i, 0);
            countMap.put(i, count + 1);
        }
        int maxLucky = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (Objects.equals(entry.getKey(), entry.getValue()) && entry.getKey() > maxLucky){
                maxLucky = entry.getKey();
            }
        }

        return maxLucky;
    }
}