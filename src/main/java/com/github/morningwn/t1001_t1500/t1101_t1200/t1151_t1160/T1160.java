package com.github.morningwn.t1001_t1500.t1101_t1200.t1151_t1160;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-words-that-can-be-formed-by-characters/">1160. 拼写单词</a>
 *
 * @author morningwn
 * @date
 */
public class T1160 {

    @Test
    public void test() {

//        String[] words = {"cat","bt","hat","tree"}; //chars = "atach"  6
//        Out.println( countCharacters( words, "atach" ) );


        String[] words = {"hello", "world", "leetcode"};  // 10
        Out.println(countCharacters(words, "welldonehoneyr"));

    }

    public int countCharacters(String[] words, String chars) {

        int res = 0;
        Map<Character, Integer> dir = new HashMap<Character, Integer>();

        for (char i : chars.toCharArray()) {
            int count = dir.getOrDefault(i, 0) + 1;
            dir.put(i, count);
        }

        for (int i = 0; i < words.length; i++) {

            boolean spell = true;

            Map<Character, Integer> tmp = new HashMap<Character, Integer>(dir);
            for (char letter : words[i].toCharArray()) {
                int count = tmp.getOrDefault(letter, 0) - 1;
                if (count >= 0) {
                    tmp.put(letter, count);
                } else {
                    spell = false;
                    break;
                }
            }

            if (spell) {
                res += words[i].length();
            }
        }

        return res;
    }

}
