package com.github.morningwn.t1001_t1500.t1301_t1400;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/5/20 19:42
 */
public class T1371 {


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
