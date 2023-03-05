package com.github.morningwn.t2501_.t6301_t6400.t6311_t6320;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/split-with-minimum-sum/">6312. 最小和分割</a>
 *
 * @author morningwn
 * @date Created in 2023/3/4 22:36
 */
public class T6312 {

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
