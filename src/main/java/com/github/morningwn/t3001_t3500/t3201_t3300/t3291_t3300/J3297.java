package com.github.morningwn.t3001_t3500.t3201_t3300.t3291_t3300;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/"></a>
 *
 * @author morningwn
 * @date 2025-01-09 10:45:24
 */
public class J3297 {

    @Test
    public void test() {
        Assert.assertEquals(1, validSubstringCount("abc", "abc"));
        Assert.assertEquals(1, validSubstringCount("bcca", "abc"));
        Assert.assertEquals(10, validSubstringCount("abcabc", "abc"));
        Assert.assertEquals(12, validSubstringCount("abcdabc", "abc"));
        Assert.assertEquals(0, validSubstringCount("abcabc", "aaabc"));
    }

    public String buildTest(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append('a');
        }
        return sb.toString();
    }

    public long validSubstringCount(String word1, String word2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] charArray = word1.toCharArray();
        long count = 0L;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            Integer cCount = map.get(c);
            if (cCount != null) {
                if (cCount == 1) {
                    map.remove(c);
                } else {
                    map.put(c, cCount - 1);
                }
            }
            if (map.isEmpty()) {
                count += charArray.length - i;
            }
        }

        return count;
    }

}