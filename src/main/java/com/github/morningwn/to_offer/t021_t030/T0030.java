package com.github.morningwn.to_offer.t021_t030;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author morningwn
 * @date Created in 2020/7/8 21:47
 */
public class T0030 {

    @Test
    public void test() {
        Deque<Integer> queue = new LinkedList<>();
        queue.push(1);
        queue.push(2);
        queue.push(9);
        queue.push(5);

        Out.println(queue.pollFirst());
        Out.println(queue.pollFirst());
        Out.println(queue.peekFirst());
        Out.println(queue);
    }

    class MinStack {

        private final Deque<Integer> stack;
        private int minNum;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
            minNum = Integer.MAX_VALUE;
        }

        public void push(int x) {
            stack.push(x);
            if (minNum > x) {
                minNum = x;
            }
        }

        public void pop() {
            stack.pollFirst();
            getMinNum();
        }

        public int top() {
            return stack.peekFirst();
        }

        public int min() {
            return minNum;
        }

        private void getMinNum() {
            minNum = Integer.MAX_VALUE;
            for (int num : stack) {
                minNum = Math.min(minNum, num);
            }
        }
    }
}
