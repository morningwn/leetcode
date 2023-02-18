package com.github.morningwn.t1001_t1500.t1001_t1100.t1041_t1050;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author morningwn
 * @version 1.0.0
 * @date 2021/3/9 14:29
 */
public class T1047 {

    public String removeDuplicates(String S) {

        Deque<Character> stack = new LinkedList<>();
        char[] chars = S.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else {
                boolean flag = true;

                if (stack.peek().equals(chars[i])) {
                    stack.pop();
                    flag = false;
                }

                while (!stack.isEmpty() && stack.peek().equals(chars[i])) {
                    stack.pop();
                }
                if (flag) {
                    stack.push(chars[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }
}
