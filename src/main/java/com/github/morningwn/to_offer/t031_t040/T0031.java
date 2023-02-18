package com.github.morningwn.to_offer.t031_t040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Stack;

/**
 * @author morningwn
 * @date Created in 2020/7/9 10:00
 */
public class T0031 {

    @Test
    public void test() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};

        Out.println(validateStackSequences(pushed, popped));
    }

    /**
     * @author morningwn
     * @date 2020/7/9 10:18
     * @description: 模拟出入栈操作，优化
     * @param: pushed
     * @param: popped
     * @return: boolean
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        for (int num : pushed) {
            stack.add(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }

    /**
     * @author morningwn
     * @date 2020/7/9 10:13
     * @description: 模拟出入栈操作
     * @version: 1.0
     * @param: pushed 入栈顺序
     * @param: popped 出栈顺序
     * @return: boolean 结果
     */
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        boolean stop = false;
        while (!stop) {
            stop = true;
            if (i < pushed.length) {
                stack.add(pushed[i++]);
                stop = false;
            }
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                Out.println(stack.pop());
                j++;
                stop = false;
            }
        }

        return i == pushed.length && j == popped.length;
    }

}
