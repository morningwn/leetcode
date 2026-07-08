package com.github.morningwn.t1001_t1500.t1301_t1400.t1301_t1310;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/find-n-unique-integers-sum-up-to-zero/">1304. 和为零的 N 个不同整数</a>
 *
 * @author morningwn
 * @date 2020.03.22 19:52
 */
public class J1304 {

    @Test
    public void test() {
        for (int num : sumZero(4)) {
            Out.println(num + "\t ");
        }
    }

    public int[] sumZero(int n) {

        if (n == 0) {
            return new int[0];
        }
        int[] nums = new int[n];
        int lastNum = 0;

        for (int i = 1; i < n; i++) {
            nums[i - 1] = i;
            lastNum += i;
        }
        nums[n - 1] = -lastNum;

        return nums;
    }
}
