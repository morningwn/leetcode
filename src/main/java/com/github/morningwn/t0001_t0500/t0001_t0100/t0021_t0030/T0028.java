package com.github.morningwn.t0001_t0500.t0001_t0100.t0021_t0030;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/implement-strstr/">28. 实现 strStr()</a>
 *
 * @author morningwn
 * @date Created in
 */
public class T0028 {

    @Test
    public void test() {

//        Out.println( strStr( "hello", "ll" ) );      //2
//        Out.println( strStr( "aaaaa", "bba" ) );     //-1
//        Out.println( strStr( "", "" ) );             //0
//        Out.println( strStr( "", "a" ) );            //-1
//
//        Out.println( strStr( "asdcasc", "as" ) );    //0
//        Out.println( strStr( "vdsacacs", "vda" ) );  //-1
//        Out.println( strStr( "bsdfvd", "fvs" ) );    //-1
//        Out.println( strStr( "asncajkscn", "cn" ) ); //8
//
//        Out.println( strStr( "aaa", "aaaaa" ) );             //-1
//        Out.println( strStr( "mississippi", "issip" ) );             //4
        Out.println(strStr("aabaaabaaac", "aabaaac"));             //4

    }

    public int strStr(String haystack, String needle) {

        if (needle == "" || "".equals(needle)) {
            return 0;
        }

        int i = 0;
        boolean content = true;

        while (i < haystack.length()) {
            content = true;
            for (int j = 0; j < needle.length(); j++) {

                if (i + j >= haystack.length()) {
                    content = false;
                    break;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    content = false;
                    break;
                }
            }

            if (content) {
                return i;
            } else {
                i++;
            }
        }

        return -1;
    }


    //错误方法
    public int strStr1(String haystack, String needle) {

        if (needle == "" || "".equals(needle)) {
            return 0;
        }

        int i = 0;
        boolean content = true;

        while (i <= haystack.length()) {
            content = true;
            for (int j = 0; j < needle.length(); j++) {

                Out.println(i + " \t " + j);

                if (i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
                    content = false;

                    if (j < 2) {
                        i++;
                    } else {
                        i += j - 1;
                    }

                    break;

                }

            }

            if (content) {
                return i;
            }
        }

        return -1;
    }
}
