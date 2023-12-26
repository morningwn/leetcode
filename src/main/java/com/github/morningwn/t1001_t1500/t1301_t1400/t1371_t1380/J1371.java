package com.github.morningwn.t1001_t1500.t1301_t1400.t1371_t1380;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;


/**
 * <a href="https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts/">1371. 每个元音包含偶数次的最长子字符串</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#BitManipulation}</li>
 * <li>{@link Topic#HashTable}</li>
 * <li>{@link Topic#String}</li>
 * <li>{@link Topic#PrefixSum}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2020/5/20 19:42
 */
public class J1371 {

    @Test
    public void test() {
        Out.println(findTheLongestSubstring("eleetminicoworoep"));       //13
        Out.println(findTheLongestSubstring("leetcodeisgreat"));       //5
        Out.println(findTheLongestSubstring("bcbcbc"));       //6

    }

    public int findTheLongestSubstring(String s) {
        int[] flags = new int[s.length() + 1];
        char[] cs = s.toCharArray();
        flags[0] = 0;
        for (int i = 1; i <= cs.length; i++) {
            switch (cs[i - 1]) {
                case 'a':
                    flags[i] = flags[i - 1] ^ 1;
                    break;
                case 'e':
                    flags[i] = flags[i - 1] ^ 2;
                    break;
                case 'i':
                    flags[i] = flags[i - 1] ^ 4;
                    break;
                case 'o':
                    flags[i] = flags[i - 1] ^ 8;
                    break;
                case 'u':
                    flags[i] = flags[i - 1] ^ 16;
                    break;
                default:
                    flags[i] = flags[i - 1];
                    break;
            }
//            Out.println(flags[i] + "\t " + cs[i-1] + "\t "+Integer.toString(flags[i], 2));
        }

        int res = 0;
        for (int i = 0; i < flags.length; i++) {
            for (int j = flags.length - 1; j > i; j--) {
                if (flags[i] == flags[j]) {
                    res = Math.max(j - i, res);
                    break;
                }
            }

            if (res > flags.length - i) {
                break;
            }
        }
        return res;
    }

}
