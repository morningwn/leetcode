package com.github.morningwn.t0001_t0500.t0001_t0100.t0011_t0020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T0020 {

    @Test
    public void test() {

        Out.println(isValid("["));            //true
        Out.println(isValid("()[]{}"));        //true
        Out.println(isValid("(]"));            //false
        Out.println(isValid("([)]"));          //false
        Out.println(isValid("{[]}"));          //true
        Out.println(isValid("{{)}"));          //false

    }

    public boolean isValid(String s) {

        List<Integer> stoke = new ArrayList<Integer>();     //存储还未配对的括号，用于判断

        //对字符串进行遍历
        for (char i : s.toCharArray()) {

            //如果是左括号就将其压入栈中，右括号就进行对应的处理
            if (i == '(' || i == '{' || i == '[') {
                stoke.add((int) i);
            } else {

                //如果栈中已经空了，就返回false
                if (stoke.size() == 0) {
                    return false;
                }

                //栈中存储的括号能和当前括号配对就将其出栈，否则返回false
                if (((int) i - stoke.get(stoke.size() - 1)) < 3 && ((int) i - stoke.get(stoke.size() - 1)) > 0) {
                    stoke.remove(stoke.size() - 1);
                } else {
                    return false;
                }
            }
        }

        //只有栈中已经空了才返回true
        return stoke.size() == 0;
    }
}
