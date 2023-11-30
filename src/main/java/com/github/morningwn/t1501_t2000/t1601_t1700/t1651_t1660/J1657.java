package com.github.morningwn.t1501_t2000.t1601_t1700.t1651_t1660;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * <a href="https://leetcode.cn/problems/determine-if-two-strings-are-close/">1657. 确定两个字符串是否接近</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#HashTable}</li>
 * <li>{@link Topic#String}</li>
 * <li>{@link Topic#Sorting}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-11-30 16:36:11
 */
public class J1657 {

    @Test
    public void test() {
        Out.println(closeStrings("abc", "cba"));
    }


    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }

        if (!map1.keySet().equals(map2.keySet())) {
            Out.println(map1.keySet());
            Out.println(map2.keySet());
            return false;
        }
        List<Integer> collect1 = map1.values().stream()
                .sorted(Integer::compare)
                .toList();
        List<Integer> collect2 = map2.values().stream()
                .sorted(Integer::compare)
                .toList();

        Out.println(collect1);
        Out.println(collect2);
        return collect1.equals(collect2);
    }
}
