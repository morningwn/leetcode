package com.github.morningwn.t2501_t3000.t2501_t2600.t2571_t2580;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/split-with-minimum-sum/">2578. 最小和分割</a>
 *
 * @author morningwn
 * @date Created in 2023/3/4 22:36
 */
public class J2578 {

    public int splitNum(int num) {
        List<Integer> nums = new ArrayList<>();
        while (num > 0) {
            nums.add(num % 10);
            num /= 10;
        }
        nums.sort(Integer::compareTo);
        int a = 0;
        int b = 0;

        for (Integer i : nums) {
            if (a < b) {
                a = a * 10 + i;
            } else {
                b = b * 10 + i;
            }
        }
        return a + b;
    }
}
