package com.github.morningwn.t0001_t0500.t0001_t0100.t0011_t0020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T0014 {

    @Test
    public void test() {
        String[] strs1 = {"flower", "flow", "flight"};
        Out.println(longestCommonPrefix(strs1));        //"fl"
        String[] strs2 = {"dog", "racecar", "car"};
        Out.println(longestCommonPrefix(strs2));        //""
        String[] strs3 = {"", "b"};
        Out.println(longestCommonPrefix(strs3));        //""
    }

    public String longestCommonPrefix(String[] strs) {

        //如果输入的字符串个数为0或者1可以直接输出结果
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        String output = "";                            //用来存储输出的结果，也就是最长公共前缀
        boolean next = true;                        //用来判断遍历是否结束
        int i = 1;                                    //标记当前所对比的是第几个字符

        //依次判断每一个字符是否相同
        while (next) {

            //依次遍历判断每一个字符串的第i个字符是否相同
            for (int j = 1; j < strs.length; j++) {

                //判断是否已经越界，如已经越界就结束循环
                if (i > strs[j].length()) {
                    next = false;
                    break;
                }

                //判断是否相同
                if (strs[0].length() < i || strs[0].charAt(i - 1) != strs[j].charAt(i - 1)) {
                    next = false;
                    break;
                }


            }

            //根据前面的结果，判断是否将当前位置的字符添加在结果中
            if (next) {
                output += strs[0].charAt(i - 1) + "";
            }

            i++;
        }

        return output;

    }
}