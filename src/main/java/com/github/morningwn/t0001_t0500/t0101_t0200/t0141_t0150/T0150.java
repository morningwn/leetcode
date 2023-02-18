package com.github.morningwn.t0001_t0500.t0101_t0200.t0141_t0150;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Stack;

/**
 * @author morningwn
 * @date 2020/9/2  10:21
 */
public class T0150 {

    @Test
    public void test() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        Out.println(evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int a = 0;
        int b = 0;
        for (String t : tokens) {
            switch (t) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b + a);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(t));
                    break;
            }
//            if ("+".equals(t)) {
//                int a = stack.pop();
//                int b = stack.pop();
//                stack.push(b+a);
//            }else if ("-".equals(t)) {
//                int a = stack.pop();
//                int b = stack.pop();
//                stack.push(b-a);
//            }else if ("/".equals(t)) {
//                int a = stack.pop();
//                int b = stack.pop();
//                stack.push(b/a);
//            }else if ("*".equals(t)) {
//                int a = stack.pop();
//                int b = stack.pop();
//                stack.push(b*a);
//            }else {
//                stack.push(Integer.parseInt(t));
//            }

            Out.println(stack);
        }

        return stack.pop();
    }
}
