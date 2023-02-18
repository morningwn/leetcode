package com.github.morningwn.t1001_t1500.t1201_t1300.t1201_t1210;

/**
 * <a href="https://leetcode.cn/problems/unique-number-of-occurrences/">1207. 独一无二的出现次数</a>
 *
 * @author morningwn
 * @date 2020/10/28 7:59
 */
public class T1207 {

    public boolean uniqueOccurrences(int[] arr) {
        int[] counts = new int[2001];
        int[] flag = new int[1001];
        for (int num : arr) {
            counts[1000 + num]++;
        }

        for (int count : counts) {
            if (flag[count] != count) {
                flag[count] = count;
            } else {
                if (count != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
