package com.github.morningwn.t0001_t0500.t0301_t0400.t0311_t0320;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 318. 最大单词长度乘积
 * <link>https://leetcode-cn.com/problems/maximum-product-of-word-lengths/</link>
 *
 * @author morningwn
 * @date Created in 2021/11/17 9:58
 */
public class T0318 {

    @Test
    public void test() {

//        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};

        Out.println(maxProduct(words));

    }

    public int maxProduct(String[] words) {

        int[] flags = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            int flag = 0;
            for (char c : words[i].toCharArray()) {
                flag |= 1 << (c - 'a');
            }
            flags[i] = flag;
        }

        int res = 0;
        for (int i = 0; i < flags.length; i++) {
            for (int j = i + 1; j < flags.length; j++) {
                if ((flags[i] & flags[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    if (product > res) {
                        res = product;

                        Out.printf("product : %d, word1: %s, word2: %s \n", product, words[i], words[j]);
                    }
                }
            }
        }

        return res;
    }
}
