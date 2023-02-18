package com.github.morningwn.t0501_t1000.t0701_t0800.t0721_t0730;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数
 *
 * @author morningwn
 * @date 2020/9/16  0:15
 */
public class T0728 {

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            char[] nums = String.valueOf(i).toCharArray();
            boolean flag = true;
            for (char num : nums) {
                if (num <= '0' || i % (num - '0') != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                list.add(i);
            }
        }

        return list;

    }
}
