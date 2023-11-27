package com.github.morningwn.t0501_t1000.t0901_t1000.t0901_t0910;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;


/**
 * <a href="https://leetcode.cn/problems/fruit-into-baskets/">904. 水果成篮</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#Array}</li>
 * <li>{@link Topic#HashTable}</li>
 * <li>{@link Topic#SlidingWindow}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-11-27 12:03:17
 */
public class J0904 {

    @Test
    public void test() {
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int totalFruit = totalFruit(fruits);
        Out.println(totalFruit);
    }

    public int totalFruit(int[] fruits) {
        int max = 0;
        int[] baskets = new int[fruits.length];
        baskets[0] = fruits[0];

        for (int i = 1; i < fruits.length; i++) {
            baskets[i] = baskets[i - 1] ^ fruits[i];
        }

        return max;
    }
}
