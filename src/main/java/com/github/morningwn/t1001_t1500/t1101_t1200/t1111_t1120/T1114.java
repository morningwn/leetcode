package com.github.morningwn.t1001_t1500.t1101_t1200.t1111_t1120;

/**
 * <a href="https://leetcode.cn/problems/print-in-order/">1114. 按序打印</a>
 *
 * @author morningwn
 * @date Created in 2020/7/19 18:07
 */
public class T1114 {
    class Foo {
        private final Object lock = new Object();
        private boolean secondStart = false;
        private boolean thirdStart = false;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            synchronized (lock) {
                printFirst.run();
                secondStart = true;
                lock.notifyAll();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (!secondStart) {
                    lock.wait();
                }
                printSecond.run();
                thirdStart = true;
                lock.notifyAll();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (!thirdStart) {
                    lock.wait();
                }
                printThird.run();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
        }
    }
}
