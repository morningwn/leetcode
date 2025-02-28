package com.github.morningwn.t2001_t2500.t2301_t2400.t2321_t2330;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/decode-the-message/">2325. 解密消息</a>
 *
 * @author morningwn
 * @create in 2023/2/1 0:43
 */
public class J2325 {

    public String decodeMessage(String key, String message) {
        Map<Character, Character> dictionary = new HashMap<>();
        char[] keyChars = key.toCharArray();
        int index = 0;
        for (char keyChar : keyChars) {
            if (keyChar == ' ') {
                continue;
            }
            if (!dictionary.containsKey(keyChar)) {
                dictionary.put(keyChar, (char) ('a' - 1 + index++));
            }
            if (dictionary.size() == 26) {
                break;
            }
        }

        System.out.println(dictionary);
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append(dictionary.getOrDefault(c, c));
        }

        return sb.toString();
    }
}
