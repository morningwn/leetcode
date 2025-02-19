package com.github.morningwn.t0501_t1000.t0601_t0700.t0621_t0630;

/**
 * <a href="https://leetcode.cn/problems/design-circular-queue/">622. 设计循环队列</a>
 *
 * @author morningwn
 * @create in 2022/8/2 17:21
 */
public class J0622 {

    class MyCircularQueue {
        private final int length;
        private int start;
        private int end;
        private final int[] data;

        public MyCircularQueue(int k) {
            length = k;
            start = 0;
            end = 0;
            data = new int[k];
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            data[++end % length] = value;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            start++;

            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            } else {
                return data[start % length];
            }
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            } else {
                return data[end % length];
            }
        }

        public boolean isEmpty() {
            return start == end;
        }

        public boolean isFull() {
            return start + length == end;
        }
    }
}
