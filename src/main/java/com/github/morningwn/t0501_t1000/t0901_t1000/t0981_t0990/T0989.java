package com.github.morningwn.t0501_t1000.t0901_t1000.t0981_t0990;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author morningwn
 * @description: 数组形式的整数加法
 * @date Created in 2020/4/30 16:05
 * @version: 1.0
 */
public class T0989 {

    @Test
    public void test() {
        int[] A = {1};
        Out.println(addToArrayForm(A, 99));
    }

    public List<Integer> addToArrayForm(int[] A, int K) {

        int carry = 0;
        List<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int tmp = K % 10;
            K = K / 10;
            res.add(0, (A[i] + carry + tmp) % 10);
            carry = (A[i] + carry + tmp) / 10;
        }
        while (K > 0) {
            int tmp = K % 10;
            K = K / 10;
            res.add(0, (carry + tmp) % 10);
            carry = (carry + tmp) / 10;
        }
        if (carry != 0) {
            res.add(0, carry);
        }
        return res;
    }

}
