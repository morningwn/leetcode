package com.github.morningwn.to_offer.t001_t010;

import java.util.Stack;

/**
 * @author morningwn
 * @description: 使用两个栈实现队列
 * @date Created in 2020/6/30 15:56
 * @version: 1.0
 */
public class T009 {

    public T009() {

    }

    public void test() {
        new T009();
    }

    class CQueue {
        private final Stack<Integer> stack1;
        private final Stack<Integer> stack2;


        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /* *
         * @author morningwn
         * @date 2020/6/30 16:15
         * @description 插入操作只需要向stack1插入
         * @param value
         * @return void
         * */
        public void appendTail(int value) {
            stack1.push(value);
        }

        /* *
         * @author morningwn
         * @date 2020/6/30 16:16
         * @description 删除操作
         * @return int
         * */
        public int deleteHead() {

            //当stack为空时，从stack1向stack2插入数
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            //从stack2弹出数
            if (stack2.isEmpty()) {
                return -1;
            } else {
                return stack2.pop();
            }
        }
    }

}
