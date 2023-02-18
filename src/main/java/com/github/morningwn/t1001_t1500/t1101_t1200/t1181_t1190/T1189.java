package com.github.morningwn.t1001_t1500.t1101_t1200.t1181_t1190;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-balloons/">1189. “气球” 的最大数量</a>
 *
 * @author morningwn
 * @date
 */
public class T1189 {

    @Test
    public void test() {

        Out.println(maxNumberOfBalloons("nlaebolkoo"));        //1
        Out.println(maxNumberOfBalloons("loonbalxballpoon"));        //2
        Out.println(maxNumberOfBalloons("leetcode"));        //0
        Out.println(maxNumberOfBalloons(""));        //0

    }

    //balloon
    public int maxNumberOfBalloons(String text) {

        float[] letters = new float[5];

        for (char l : text.toCharArray()) {
            switch (l) {
                case 'b':
                    letters[0]++;
                    break;
                case 'a':
                    letters[1]++;
                    break;
                case 'l':
                    letters[2] += 0.5;
                    break;
                case 'o':
                    letters[3] += 0.5;
                    break;
                case 'n':
                    letters[4]++;
                    break;
                default:
                    break;
            }
        }

        int count = Integer.MAX_VALUE;

        for (float i : letters) {
            if (count > i) {
                count = (int) i;
            }
        }

        return count;
    }
}
