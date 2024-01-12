package com.github.morningwn.t2001_t2500.t2001_t2100.t2081_t2090;

import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * <a href="https://leetcode.cn/problems/count-common-words-with-one-occurrence/">2085. 统计出现过一次的公共字符串</a>
 * <ul>
 * <li>{@link Difficulty#Easy}</li>
 * <li>{@link Topic#Array}</li>
 * <li>{@link Topic#HashTable}</li>
 * <li>{@link Topic#String}</li>
 * <li>{@link Topic#Counting}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2024-01-12 14:12:40
 */
public class J2085 {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> word1Map = new HashMap<>();
        Map<String, Integer> word2Map = new HashMap<>();

        for (String word : words1) {
            word1Map.put(word, 1 + word1Map.getOrDefault(word, 0));
        }
        for (String word : words2) {
            word2Map.put(word, 1 + word2Map.getOrDefault(word, 0));
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : word1Map.entrySet()) {
            if (entry.getValue() == 1 && word2Map.getOrDefault(entry.getKey(), 0) == 1) {
                count++;
            }
        }
        return count;
    }
}
