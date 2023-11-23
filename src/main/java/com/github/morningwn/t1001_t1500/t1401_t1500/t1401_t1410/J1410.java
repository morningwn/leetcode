package com.github.morningwn.t1001_t1500.t1401_t1500.t1401_t1410;

import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * <a href="https://leetcode.cn/problems/html-entity-parser/">1,410. HTML 实体解析器</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#HashTable}</li>
 * <li>{@link Topic#String}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-11-23 10:54:48
 */
public class J1410 {

    @Test
    public void test() {

    }

    public String entityParser(String text) {
        Map<String, String> keys = new HashMap<>();
        keys.put("&quot;", "\"");
        keys.put("&apos;", "'");
        keys.put("&amp;", "&");
        keys.put("&gt;", ">");
        keys.put("&lt;", "<");
        keys.put("&frasl;", "/");

        StringBuilder sb = new StringBuilder();
        StringBuilder flag = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c == '&') {
                sb.append(flag.toString());
                flag = new StringBuilder("&");
            } else {
                if (flag.isEmpty()) {
                    sb.append(c);
                } else {
                    flag.append(c);
                    if (keys.containsKey(flag.toString())) {
                        sb.append(keys.get(flag.toString()));
                        flag = new StringBuilder();
                    }
                }
            }
        }
        sb.append(keys.getOrDefault(flag.toString(), flag.toString()));
        return sb.toString();
    }
}
