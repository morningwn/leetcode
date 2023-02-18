package com.github.morningwn.t0001_t0500.t0101_t0200.t0161_t0170;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 重复的DNA序列
 *
 * @author moringwn
 * @date 2021/10/8 下午4:50
 */
public class T0187 {
    public List<String> findRepeatedDnaSequences(String s) {


        List<String> res = new ArrayList<>();
        if (s.length() < 10) {
            return res;
        }
        Map<Character, Integer> MASK_MAP = new HashMap<Character, Integer>() {{
            put('A', 0b00);
            put('C', 0b01);
            put('G', 0b10);
            put('T', 0b11);
        }};

        int num = 1 << 20;
        int[] map = new int[num];

        for (int i = 0; i < 10; i++) {
            num = (num << 2) | MASK_MAP.get(s.charAt(i));
        }

        map[num]++;

        for (int i = 10; i < s.length(); i++) {
            // 只要20位
            num = ((num << 2) | MASK_MAP.get(s.charAt(i))) & 0xfffff;

            map[num]++;
            if (map[num] == 2) {
                res.add(s.substring(i - 9, i + 1));
            }
        }

        return res;
    }

    public List<String> findRepeatedDnaSequences1(String s) {

        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String tmp = s.substring(i, i + 10);
            int count = map.getOrDefault(tmp, 0) + 1;
            map.put(tmp, count);
            if (count == 2) {
                res.add(tmp);
            }
        }

        return res;
    }
}
