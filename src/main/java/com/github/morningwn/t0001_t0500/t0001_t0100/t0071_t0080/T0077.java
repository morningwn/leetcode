package com.github.morningwn.t0001_t0500.t0001_t0100.t0071_t0080;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author morningwn
 * @date 2020/9/8  15:58
 */
public class T0077 {

    @Test
    public void test() {
        int n = 4;
        int k = 2;
        Out.println(combine(n, k));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> list = new Stack<>();

        helper(res, list, 1, n, k);

        return res;
    }

    public void helper(List<List<Integer>> res, Stack<Integer> list, int index, int n, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (index > n) {
            return;
        }
        if (list.size() > 0 && list.peek() >= n) {
            return;
        }

        for (int i = index; i <= n; i++) {
            list.push(i);
            helper(res, list, i + 1, n, k);
            list.pop();
        }
    }
}
