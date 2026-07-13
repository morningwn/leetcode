package com.github.morningwn.t1001_t1500.t1201_t1300.t1291_t1300;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/sequential-digits">1291. 顺次数</a>
 *
 * @author moringwn
 * @date
 */
public class J1291 {

    @Test
    public void test() {
        Assert.assertEquals(Lists.newArrayList(234, 345, 456, 567, 678, 789), sequentialDigits(211, 1000));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> sequentialDigits = new ArrayList<>();
        int start = 12;
        int i = 3;
        int len = 11;
        while (start <= low) {
            if (start * 10 > low) {
                break;
            }
            len = len * 10 + 1;
            start = start * 10 + i++;
        }

        while (start <= high) {
            int tmp = start;
            for (int j = 0; j < 11 - i; j++) {
                if (tmp > high) {
                    return sequentialDigits;
                }
                if (tmp >= low) {
                    sequentialDigits.add(tmp);
                }
                tmp += len;
            }
            len = len * 10 + 1;
            start = start * 10 + i++;
        }
        return sequentialDigits;
    }
}
