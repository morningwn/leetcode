package com.github.morningwn.interview;

/**
 * <a href="https://leetcode.cn/problems/check-permutation-lcci/">面试题 01.02. 判定是否互为字符重排</a>
 *
 * @author morningwn
 * @create in 2022/9/27 10:06
 */
public class T01_02 {

    public boolean CheckPermutation(String s1, String s2) {
        int[] letterCount = new int[26];
        int ls1 = s1.length();
        int ls2 = s2.length();
        if (ls1 != ls2) {
            return false;
        }
        char[] s1Letter = s1.toCharArray();
        char[] s2Lettet = s2.toCharArray();

        for (int i = 0; i < ls1; i++) {
            letterCount[s1Letter[i] - 'a'] += 1;
            letterCount[s2Lettet[i] - 'a'] -= 1;
        }

        for (int count : letterCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
