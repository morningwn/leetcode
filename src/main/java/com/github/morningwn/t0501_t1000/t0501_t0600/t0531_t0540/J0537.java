package com.github.morningwn.t0501_t1000.t0501_t0600.t0531_t0540;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;


/**
 * <a href="https://leetcode.cn/problems/complex-number-multiplication/">537. 复数乘法</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#Math}</li>
 * <li>{@link Topic#String}</li>
 * <li>{@link Topic#Simulation}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2020-03-05 21:00:52
 */
public class J0537 {

    @Test
    public void test() {
        //0+2i
        Out.println(complexNumberMultiply("1+1i", "1+1i"));
        //-2+0i
        Out.println(complexNumberMultiply("1+1i", "-1+1i"));
        //0+-2i
        Out.println(complexNumberMultiply("1+-1i", "1+-1i"));

        Out.println(complexNumberMultiply("0+0i", "1+-1i"));
    }

    public String complexNumberMultiply(String a, String b) {

        StringBuilder res = new StringBuilder();

        int aspit = a.indexOf('+');
        int bspit = b.indexOf('+');

        int aa = Integer.parseInt(a.substring(0, aspit));
        int ab = Integer.parseInt(a.substring(aspit + 1, a.length() - 1));
        int ba = Integer.parseInt(b.substring(0, bspit));
        int bb = Integer.parseInt(b.substring(bspit + 1, b.length() - 1));

        res.append(aa * ba - ab * bb);
        res.append('+');
        res.append(aa * bb + ab * ba);
        res.append('i');

        return res.toString();
    }

}
