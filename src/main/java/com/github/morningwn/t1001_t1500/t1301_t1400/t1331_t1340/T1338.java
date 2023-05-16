package com.github.morningwn.t1001_t1500.t1301_t1400.t1331_t1340;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/reduce-array-size-to-the-half/">1338. 数组大小减半</a>
 *
 * @author morningwn
 * @date 2020/11/10 22:57
 */
public class T1338 {
    public int minSetSize(int[] arr) {
        int[] counts = new int[100001];
        for (int num : arr) {
            counts[num]++;
        }
        Arrays.sort(counts);

        int res = 0;
        int count = arr.length % 2 == 0 ? arr.length / 2 : arr.length / 2 + 1;

        for (int i = counts.length - 1; i >= 0; i--) {
            if (count > 0) {
                count -= counts[i];
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    public int minSetSize1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int res = 0;
        int count = arr.length % 2 == 0 ? arr.length / 2 : arr.length / 2 + 1;

        Object[] objects = map.values().stream().sorted(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return -Integer.compare(o1, o2);
                    }
                }
        ).toArray();

        for (Object o : objects) {
            if (count > 0) {
                count -= (int) o;
                res++;
            } else {
                break;
            }
        }

        return res;
    }
}
