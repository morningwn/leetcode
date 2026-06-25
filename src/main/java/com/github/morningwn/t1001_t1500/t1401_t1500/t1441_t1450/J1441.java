package com.github.morningwn.t1001_t1500.t1401_t1500.t1441_t1450;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/build-an-array-with-stack-operations/'>1441. 用栈操作构建数组</a>
 *
 * @author morningwn
 * @date Created in 2020/5/10 10:41
 */
public class J1441 {

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
        }
        return res;
    }

}
