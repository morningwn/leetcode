package com.github.morningwn.t0001_t0500.t0201_t0300.t0231_t0240;

import java.util.Stack;

public class T0232 {
}

class MyQueue {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {

        if (!stack2.empty()) {
            return stack2.pop();
        }

        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.empty()) {
            return stack2.peek();
        }

        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }

        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack2.empty() && stack1.empty();
    }
}