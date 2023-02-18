package com.github.morningwn.t0001_t0500.t0001_t0100.t0011_t0020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.HashMap;

public class T0013 {

    @Test
    public void test() {
        Out.println(romanToInt("III"));        //3
        Out.println(romanToInt("IV"));        //4
        Out.println(romanToInt("IX"));        //9
        Out.println(romanToInt("LVIII"));    //58
        Out.println(romanToInt("MCMXCIV"));    //1994
    }

    public int romanToInt(String s) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        if (s.length() > 1 && map.containsKey(s.substring(0, 2))) {
            return map.get(s.substring(0, 2)) + romanToInt(s.substring(2));
        } else if (s.length() > 0 && map.containsKey(s.substring(0, 1))) {
            return map.get(s.substring(0, 1)) + romanToInt(s.substring(1));
        } else if (map.containsKey(s)) {
            return map.get(s.substring(0, 1));
        } else {
            return 0;
        }
    }
}