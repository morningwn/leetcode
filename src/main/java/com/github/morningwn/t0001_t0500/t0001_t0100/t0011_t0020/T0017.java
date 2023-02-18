package com.github.morningwn.t0001_t0500.t0001_t0100.t0011_t0020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T0017 {

    @Test
    public void test() {

        String digits = "22ss";

        //String tmp = String.format( "%"+digits.length()+"s", "12" );
        //Out.println( tmp );

        Out.println(letterCombinations("22"));      //[aa, ab, ac, ba, bb, bc, ca, cb, cc]

        Out.println(letterCombinations("7"));
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();        //存储结果，用于输出

        //长度为零时直接输出空
        if (digits.length() == 0) {
            return result;
        }

        //字典，存储每个数字对于的几个结果
        Map<String, Map<String, String>> dir = new HashMap<>();

        Map<String, String> dir2 = new HashMap<>();
        Map<String, String> dir3 = new HashMap<>();
        Map<String, String> dir4 = new HashMap<>();
        Map<String, String> dir5 = new HashMap<>();
        Map<String, String> dir6 = new HashMap<>();
        Map<String, String> dir7 = new HashMap<>();
        Map<String, String> dir8 = new HashMap<>();
        Map<String, String> dir9 = new HashMap<>();

        dir2.put("0", "a");
        dir2.put("1", "b");
        dir2.put("2", "c");
        dir2.put("3", "");

        dir3.put("0", "d");
        dir3.put("1", "e");
        dir3.put("2", "f");
        dir3.put("3", "");

        dir4.put("0", "g");
        dir4.put("1", "h");
        dir4.put("2", "i");
        dir4.put("3", "");

        dir5.put("0", "j");
        dir5.put("1", "k");
        dir5.put("2", "l");
        dir5.put("3", "");

        dir6.put("0", "m");
        dir6.put("1", "n");
        dir6.put("2", "o");
        dir6.put("3", "");

        dir7.put("0", "p");
        dir7.put("1", "q");
        dir7.put("2", "r");
        dir7.put("3", "s");

        dir8.put("0", "t");
        dir8.put("1", "u");
        dir8.put("2", "v");
        dir8.put("3", "");

        dir9.put("0", "w");
        dir9.put("1", "x");
        dir9.put("2", "y");
        dir9.put("3", "z");

        dir.put("2", dir2);
        dir.put("3", dir3);
        dir.put("4", dir4);
        dir.put("5", dir5);
        dir.put("6", dir6);
        dir.put("7", dir7);
        dir.put("8", dir8);
        dir.put("9", dir9);

        //循环4的digits.length()次幂，排除其中多余的结果，得到正确的
        for (int i = 0; i < Math.pow(4, digits.length()); i++) {

            //将i转化为4进制的数，并将字符串的长度匹配为digits.length()
            String tmp = String.format("%" + digits.length() + "s", Integer.toString(i, 4));
            // Out.println( tmp );

            String output = "";     //本次结果

            //根据tmp的字符，通过字典转化为结果
            for (int j = 0; j < digits.length(); j++) {
                output += dir.get(digits.charAt(j) + "").get(tmp.charAt(j) == ' ' ? "0" : tmp.charAt(j) + "");
            }

            //判断得到的结果是否合法
            if (output.length() == digits.length()) {
                result.add(output);
            }
        }

        return result;
    }
}
