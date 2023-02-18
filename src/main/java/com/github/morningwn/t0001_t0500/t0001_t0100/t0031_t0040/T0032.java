package com.github.morningwn.t0001_t0500.t0001_t0100.t0031_t0040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Stack;

/**
 * @author morningwn
 * @description: 最长有效括号
 * @date Created in 2020/7/5 16:51
 * @version: 1.0
 */
public class T0032 {

    @Test
    public void test() {
//        String s = ")())()()";
//        String s = ")()())";
//        String s = "(()";
//        String s = "()(()";
        String s = ")()()((()))()(())))((";      //16
//        String s = "";
//        String s = "";

        Out.println(longestValidParentheses(s));
    }

    /**
     * @author morningwn
     * @date 2020/7/5 21:16
     * @description: 先找到所有能够匹配的括号，做好标记，然后统计连续的最大值
     * @param: s 括号串
     * @return: int 结果
     */
    public int longestValidParentheses(String s) {
        Stack<MyNodeHelper> stack = new Stack<>();
        boolean[] match = new boolean[s.length()];
        int res = 0;

        //先找到所有成对的
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(') {
                stack.add(new MyNodeHelper(i, tmp));
            } else {
                if (stack.isEmpty()) {
                    match[i] = false;
                } else {
                    match[i] = true;
                    MyNodeHelper helper = stack.pop();
                    match[helper.index] = true;
                }
            }
        }

        //统计结果
        int tmp = 0;
        for (boolean m : match) {
            if (m) {
                tmp++;
            } else {
                tmp = 0;
            }
            res = Math.max(res, tmp);
        }

        return res;

    }

    /***
     * @author morningwn
     * @date 2020/7/5 21:17
     * @description: 用来存储位置
     * */
    class MyNodeHelper {
        int index;
        char val;

        public MyNodeHelper(int index, char val) {
            this.index = index;
            this.val = val;
        }
    }

}
