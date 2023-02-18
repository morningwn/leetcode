package com.github.morningwn.to_offer.t011_t020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author morningwn
 * @description: 打印从1到最大的n位数
 * @date Created in 2020/7/4 15:34
 * @version: 1.0
 */
public class T0017 {

    @Test
    public void test() {
        Out.println(printNumbers(3));
    }

    /**
     * @author morningwn
     * @date 2020/7/4 15:39
     * @description: 使用全排列的解法，对n没有限制，非递归
     * @param: n 位数
     * @return: int[] 结果
     */
    public List<String> printNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        List<String> res = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            String tmp = String.valueOf(i);
            queue.offer(tmp);
            res.add(tmp);
        }

        for (int i = 1; i < n; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String num = queue.poll();
                for (int k = 0; k <= 9; k++) {
                    String tmp = num + k;
                    queue.offer(tmp);
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    /**
     * @author morningwn
     * @date 2020/7/4 15:35
     * @description: 暴力循环
     * @version: 1.0
     * @param: n 位数
     * @return: int[] 结果
     */
    public int[] printNumbers1(int n) {
        int max = (int) Math.pow(10, n);
        int[] numbers = new int[max - 1];

        for (int i = 1; i < max; i++) {
            numbers[i - 1] = i;
        }

        return numbers;
    }

}
