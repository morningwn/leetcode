package com.github.morningwn.t1001_t1500.t1401_t1500.t1401_t1410;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * <a href="https://leetcode.cn/problems/html-entity-parser/">1410. HTML 实体解析器</a>
 *
 * @author morningwn
 * @date
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

        StringBuilder sb  = new StringBuilder();
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
