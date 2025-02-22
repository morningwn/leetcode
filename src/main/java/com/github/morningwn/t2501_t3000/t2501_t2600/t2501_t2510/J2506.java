package com.github.morningwn.t2501_t3000.t2501_t2600.t2501_t2510;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/count-pairs-of-similar-strings">2506. 统计相似字符串对的数目</a>
 *
 * @author morningwn
 * @date Created in 2025/2/22 15:40
 */
public class J2506 {

    public int similarPairs(String[] words) {
        int pairCount = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            String s = getUniqueCharactersString(word);
            int count = map.getOrDefault(s, 0) + 1;
            map.put(s, count);
            pairCount += count - 1;
        }
        return pairCount;
    }


    public String getUniqueCharactersString(String input) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : input.toCharArray()) {
            uniqueChars.add(c);
        }
        StringBuilder result = new StringBuilder();
        for (Character c : uniqueChars) {
            result.append(c);
        }
        return result.toString();
    }
}