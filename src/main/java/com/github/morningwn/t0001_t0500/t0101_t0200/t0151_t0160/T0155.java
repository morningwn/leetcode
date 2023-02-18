package com.github.morningwn.t0001_t0500.t0101_t0200.t0151_t0160;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author morningwn
 * @date Created in 2020/5/12 11:30
 */
public class T0155 {

    @Test
    public void test() {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            Out.println(it.next());
            Out.println(it.next());

        }
    }

    class MinStack {
        private final List<Integer> stack;
        private int minValue;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
            minValue = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if (minValue > x) {
                minValue = x;
            }
            stack.add(0, x);
        }

        public void pop() {
            if (stack.get(0) == minValue) {
                stack.remove(0);
                minValue = Integer.MAX_VALUE;
//                for (int i = 0; i < stack.size(); i++) {
//                    if (stack.get(i) < minValue) {
//                        minValue = stack.get(i);
//                    }
//                }
                for (Iterator<Integer> it = stack.iterator(); it.hasNext(); ) {
                    int tmp = it.next();
                    minValue = minValue > tmp ? tmp : minValue;
                }
            } else {
                stack.remove(0);
            }
        }

        public int top() {
            return stack.get(0);
        }

        public int getMin() {
            return minValue;
        }
    }
}
