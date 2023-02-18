package com.github.morningwn.t0501_t1000.t0501_t0600.t0521_t0530;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 *
 * @author moringwn
 * @date 2021/9/14 上午9:27
 */
public class T0524 {

    @Test
    public void test() {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea");

        Out.println(findLongestWord(s, dictionary));
    }

    public String findLongestWord(String s, List<String> dictionary) {

        String res = "";

        for (String word : dictionary) {

            int i = 0;
            int j = 0;

            while (i < s.length() && j < word.length()) {
                if (word.charAt(j) == s.charAt(i)) {
                    j++;
                }
                i++;
            }

            if (j == word.length() && compare(res, word)) {
                res = word;
            }
        }

        return res;
    }

    /**
     * 比较
     *
     * @param oldVal
     * @param newVal
     * @return 是否交换
     */
    private boolean compare(String oldVal, String newVal) {
        if (oldVal.length() > newVal.length()) {
            return false;
        } else if (oldVal.length() == newVal.length()) {
            return oldVal.compareTo(newVal) > 0;
        } else {
            return true;
        }
    }
}
