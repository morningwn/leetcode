package com.github.morningwn.t2501_.t5401_t5500.t5401_t5410;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author morningwn
 * @date Created in 2020/5/10 10:41
 */
public class T5404 {

    @Test
    public void test() {
        int[] target = {2, 3, 4};
        int n = 4;
        Out.println(buildArray(target, n));
    }

    public List<String> buildArray(int[] target, int n) {

        List<String> res = new LinkedList<>();
        int count = 1;
        for (int num : target) {
            while (count++ < num) {
                res.add("Push");
                res.add("Pop");
            }
            res.add("Push");
//            count++;
        }
        return res;
    }

}
