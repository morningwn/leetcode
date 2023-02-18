package com.github.morningwn.t1001_t1500.t1001_t1100.t1001_t1010;

import java.util.ArrayList;
import java.util.List;

/**
 * <a hraf="https://leetcode.cn/problems/find-common-characters/">1002. 查找共用字符</a>
 *
 * @author morningwn
 * @date 2020/10/14  14:43
 */
public class T1002 {

    public List<String> commonChars(String[] A) {
        int[] count = new int[26];

        for (int i = 0; i < A[0].length(); i++) {
            count[A[0].charAt(i) - 'a']++;
        }

        for (int i = 1; i < A.length; i++) {
            char[] chars = A[i].toCharArray();
            int[] tmp = new int[26];
            for (char c : chars) {
                if (count[c - 'a'] > 0) {
                    count[c - 'a']--;
                    tmp[c - 'a']++;
                }
            }
            count = tmp;
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }

//    public List<String> commonChars(String[] A) {
//
//        List<String> res = new ArrayList<>();
//        if (A == null || A.length == 0) { return res; }
//
//        for (int i = 0; i < A[0].length(); i++) {
//            res.add(String.valueOf(A[0].charAt(i)));
//        }
//
//        for (int i = 1; i < A.length; i++) {
//            List<String> tmp = new ArrayList<>();
//            char[] arr = A[i].toCharArray();
//            for (char c : arr) {
//                if (res.contains(String.valueOf(c))) {
//                    res.remove(String.valueOf(c));
//                    tmp.add(String.valueOf(c));
//                }
//            }
//            res = tmp;
//        }
//
//        return res;
//    }
}
