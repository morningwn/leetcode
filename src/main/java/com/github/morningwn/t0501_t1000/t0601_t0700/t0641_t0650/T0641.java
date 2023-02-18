package com.github.morningwn.t0501_t1000.t0601_t0700.t0641_t0650;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/design-circular-deque/">641. 设计循环双端队列</a>
 *
 * @author morningwn
 * @create in 2022/8/15 9:34
 */
public class T0641 {

    @Test
    public void test() {
        MyCircularDeque deque = new MyCircularDeque(71);
        Out.println(deque.insertLast(1));
        Out.println(deque.getFront());
        Out.println(deque.getRear());
        Out.println(deque.insertLast(2));
        Out.println(deque.insertFront(3));
        Out.println(deque.insertFront(4));
        Out.println(deque.getFront());
        Out.println(deque.getRear());
        Out.println(deque.isFull());
        Out.println(deque.deleteLast());
        Out.println(deque.getRear());
        Out.println(deque.getFront());
        Out.println(deque.deleteFront());
        Out.println(deque.getFront());
        Out.println(deque.insertFront(4));
        Out.println(deque.getFront());
    }

    class MyCircularDeque {
        private CircularDequeNode header;
        private CircularDequeNode tail;
        private int size;
        private final int maxSize;

        public MyCircularDeque(int k) {
            size = 0;
            maxSize = k;
            header = null;
            tail = null;
        }

        public boolean insertFront(int value) {
            if (size >= maxSize) {
                return false;
            }
            size++;

            CircularDequeNode node = new CircularDequeNode(value);
            node.next = header;
            if (header != null) {
                header.pre = node;
            }
            this.header = node;

            if (tail == null) {
                tail = node;
            }
            return true;
        }

        public boolean insertLast(int value) {
            if (size >= maxSize) {
                return false;
            }
            size++;

            CircularDequeNode node = new CircularDequeNode(value);
            node.pre = tail;

            if (tail != null) {
                tail.next = node;
            }
            this.tail = node;
            if (header == null) {
                header = node;
            }

            return true;
        }

        public boolean deleteFront() {
            if (size <= 0) {
                return false;
            }
            size--;

            header = header.next;
            if (header != null) {
                header.pre = null;
            } else {
                tail = null;
            }

            return true;
        }

        public boolean deleteLast() {
            if (size <= 0) {
                return false;
            }
            size--;

            tail = tail.pre;
            if (tail != null) {
                tail.next = null;
            } else {
                header = null;
            }

            return true;
        }

        public int getFront() {
            if (size <= 0) {
                return -1;
            }

            return header.val;
        }

        public int getRear() {
            if (size <= 0) {
                return -1;
            }

            return tail.val;
        }

        public boolean isEmpty() {
            return size <= 0;
        }

        public boolean isFull() {
            return size >= maxSize;
        }
    }

    class CircularDequeNode {
        int val;
        CircularDequeNode pre;
        CircularDequeNode next;

        public CircularDequeNode(int val) {
            this.val = val;
        }
    }

}
