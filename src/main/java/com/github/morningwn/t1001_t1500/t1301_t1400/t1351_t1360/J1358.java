package com.github.morningwn.t1001_t1500.t1301_t1400.t1351_t1360;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters">1358. 包含所有三种字符的子字符串数目</a>
 *
 * @author morningwn
 * @date 2026/6/30 20:14
 */
public class J1358 {

    @Test
    public void test() {
//        System.out.println(buildString(50000));
        Assert.assertEquals(10, numberOfSubstrings("abcabc"));
        Assert.assertEquals(770, numberOfSubstrings("abcabcabababcccababaccaabbacabababccababcc"));
        Assert.assertEquals(3, numberOfSubstrings("aaacb"));
        Assert.assertEquals(1, numberOfSubstrings("acb"));
    }

    private String buildString(int len) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(3) == 0) {
                stringBuilder.append('a');
            } else if (random.nextInt(3) == 1) {
                stringBuilder.append('b');
            } else {
                stringBuilder.append('c');
            }
        }
        return stringBuilder.toString();
    }

    public int numberOfSubstrings(String s) {

        Deque<Integer> stackA = new LinkedList<>();
        Deque<Integer> stackB = new LinkedList<>();
        Deque<Integer> stackC = new LinkedList<>();

        char[] charArray = s.toCharArray();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            if (charArray[i] == 'a') {
                stackA.addLast(i);
            } else if (charArray[i] == 'b') {
                stackB.addLast(i);
            } else if (charArray[i] == 'c') {
                stackC.addLast(i);
            }
        }

        int count = 0;

        for (int i = 0; i < length - 2; i++) {
            if (stackA.isEmpty() || stackB.isEmpty() || stackC.isEmpty()) {
                break;
            }

            int index = Math.max(Math.max(stackC.peekFirst(), stackB.peekFirst()), stackA.peekFirst());
            count += length - index;

            if (charArray[i] == 'a') {
                stackA.removeFirst();
            } else if (charArray[i] == 'b') {
                stackB.removeFirst();
            } else if (charArray[i] == 'c') {
                stackC.removeFirst();
            }
        }
        return count;
    }
}
