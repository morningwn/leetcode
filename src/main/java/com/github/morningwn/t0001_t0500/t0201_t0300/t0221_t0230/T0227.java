package com.github.morningwn.t0001_t0500.t0201_t0300.t0221_t0230;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/basic-calculator-ii/">227. 基本计算器 II</a>
 * @author morningwn
 * @create in 2023/2/8 23:04
 */
public class T0227 {

    @Test
    public void test() {
        Out.print(calculate("3 + 2 * 8"));
    }
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int curNum = 0;
        char operator = '+';
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + c - '0';
            } else {
                calculate(operator, curNum, stack);
                operator = c;
                curNum = 0;
            }
        }
        calculate(operator, curNum, stack);
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    private void calculate (char operator, int curNum, Stack<Integer> stack) {
        switch (operator) {
            case '+':
                stack.push(curNum);
                break;
            case '-':
                stack.push(-curNum);
                break;
            case '*':
                stack.push(stack.pop() * curNum);
                break;
            case '/':
                stack.push(stack.pop() / curNum);
                break;
            default:
                break;
        }
    }

}
