package com.github.morningwn.t0001_t0500.t0401_t0500.t0411_t0420;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 *
 * @author moringwn
 * @date 2021/10/13 上午9:32
 */
public class T0412 {

    @Test
    public void test() {
        Out.println(1 % 3);
    }

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }

        return res;
    }
}
