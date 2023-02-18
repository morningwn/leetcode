package com.github.morningwn.t0001_t0500.t0201_t0300.t0221_t0230;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues/">225. 用队列实现栈</a>
 *
 * @author morningwn
 * @create in 2023/2/8 23:04
 */
public class T0225 {

    @Test
    public void test() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        Out.println(myStack.top());
        Out.println(myStack.pop());
        Out.println(myStack.pop());
        myStack.push(4);
        Out.println(myStack.pop());

        Out.println(myStack.empty());

    }


    class MyStack {
        private int size;
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
            size = 0;
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            size++;
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            Queue<Integer> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            size--;
            return queue1.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue1.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return size == 0;
        }
    }

}
