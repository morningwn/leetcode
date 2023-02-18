package com.github.morningwn.t0501_t1000.t0701_t0800.t0731_t0740;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/parse-lisp-expression/">736. Lisp 语法解析</a>
 *
 * @author morningwn
 * @create in 2022/7/6 10:56
 */
public class T0736 {

    @Test
    public void test() {
//        String ex = "(add 1 2)";
//        String ex = "(let x 3 x 2 5)";
//        String ex = "(add 1 2 3)";
//        String ex = "(mult 1 2 3)";

//        String ex = "(let x 2 (mult x (let x 3 y 4 (add x y))))";
//        String ex = "(let x 2 (add (let x 3 (let x 4 x)) x))";
//        String ex = "(let x 7 -12)";
//        String ex = "(let x -2 y x y)";
        String ex = "(let a (add 1 2) b (mult a 3) c 4 d (add a b) (mult d d))";
        Out.println(evaluate(ex));
    }

    public int evaluate(String expression) {
        return helper(expression.substring(1, expression.length() - 1), new HashMap<>());
    }

    public int helper(String expression, Map<String, Deque<Integer>> variables) {
        List<String> tmpVariableName = new ArrayList<>();
        List<Integer> tmpVariables = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        String variableName = null;

        String flag = null;
        Boolean isVarible = false;
        int index = 0;
        if (expression.startsWith("let")) {
            flag = "let";
            index = 4;
        } else if (expression.startsWith("add")) {
            flag = "add";
            index = 4;
        } else if (expression.startsWith("mult")) {
            flag = "mult";
            index = 5;
        }

        while (index < expression.length()) {
            char c = expression.charAt(index);
            if (c == ' ') {
                String tmp = sb.toString();
                sb.delete(0, sb.length());
                switch (flag) {
                    case "let":
                        if (isVarible) {
                            int num = getNumber(tmp, variables);
                            tmpVariables.add(num);
                            if (variableName != null) {
                                Deque<Integer> deque = variables.computeIfAbsent(variableName, k -> new LinkedList<>());
                                deque.addLast(num);
                                variableName = null;
                            }
                            isVarible = false;
                        } else {
                            variableName = tmp;
                            tmpVariableName.add(variableName);
                            isVarible = true;
                        }
                        break;
                    case "add":
                    case "mult":
                        tmpVariables.add(getNumber(tmp, variables));
                        break;
                    default:
                        break;
                }
            } else if (c == '(') {
                sb.delete(0, sb.length());
                int brackets = 1;
                index++;
                while (index < expression.length() && brackets > 0) {
                    c = expression.charAt(index);
                    if (c == ')') {
                        brackets--;
                    } else if (c == '(') {
                        brackets++;
                    }
                    sb.append(c);
                    index++;
                }
                int num = helper(sb.substring(0, sb.length() - 1), variables);
                tmpVariables.add(num);
                if (flag.equals("let") && isVarible) {
                    Deque<Integer> deque = variables.computeIfAbsent(variableName, k -> new LinkedList<>());
                    deque.addLast(num);
                    variableName = null;
                    isVarible = false;
                }
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }

            index++;
        }

        switch (flag) {
            case "let":
                if (sb.length() > 0) {
                    String tmp = sb.toString();
                    tmpVariables.add(getNumber(tmp, variables));
                }
                // 清除当前范围数据
                for (String tmp : tmpVariableName) {
                    variables.get(tmp).pollLast();
                }
                break;
            case "add":
                if (sb.length() > 0) {
                    tmpVariables.add(getNumber(sb.toString(), variables));
                }
                tmpVariables.add(tmpVariables.get(0) + tmpVariables.get(1));
                break;
            case "mult":
                if (sb.length() > 0) {
                    tmpVariables.add(getNumber(sb.toString(), variables));
                }
                tmpVariables.add(tmpVariables.get(0) * tmpVariables.get(1));
                break;
            default:
                break;
        }

        return tmpVariables.get(tmpVariables.size() - 1);
    }

    public Integer getNumber(String s, Map<String, Deque<Integer>> variable) {
        if (isNumber(s)) {
            return Integer.parseInt(s);
        } else {
            return variable.get(s).peekLast();
        }
    }

    public boolean isNumber(String s) {
        for (char c : s.toCharArray()) {
            if (c == '-' || c == '+' || ('0' <= c && '9' >= c)) {
            } else {
                return false;
            }
        }
        return true;
    }
}
