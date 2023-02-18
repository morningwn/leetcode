package com.github.morningwn.to_offer.t031_t040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.*;

/**
 * @author morningwn
 * @date Created in 2020/7/11 23:03
 */
public class T0038 {

    @Test
    public void test() {

        String[] res = permutation("abac");

        Out.println(Arrays.toString(res));
    }

    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        res.add(s);

        helper(res, s, 0);

        String[] tmp = new String[res.size()];
        res.toArray(tmp);
        return tmp;
    }

    public void helper(List<String> list, String s, int i) {
        if (i >= s.length()) {
            return;
        }
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(i));

        helper(list, s, i + 1);

        for (int j = i + 1; j < s.length(); j++) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                String tmp = swap(s, i, j);
                list.add(tmp);
                helper(list, tmp, i + 1);
            }
        }
    }

    public String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return String.valueOf(chars);
    }

}
