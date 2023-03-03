package com.github.morningwn.t0001_t0500.t0001_t0100.t0071_t0080;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.*;

/**
 * @author morningwn
 * @date Created in 2020/5/23 9:22
 */
public class T0076 {

    @Test
    public void test() {
        String s = "ADOBECODECBANC";
        String t = "ABC";
        Out.println(minWindow(s, t));
    }

    public String minWindow(String s, String t) {

        Map<Character, List<Integer>> map = new HashMap<>();
        char[] ts = t.toCharArray();

        for (int i = 0; i < ts.length; i++) {
            List<Integer> list = new ArrayList<>();
            int index = 0;
            while (index < s.length()) {
                int tmp = s.indexOf(ts[i], index);
                if (tmp != -1) {
                    list.add(tmp);
                    index = tmp + 1;
                } else {
                    break;
                }
            }
            map.put(ts[i], list);
        }
        Out.println(map);

        return "";
    }
}
