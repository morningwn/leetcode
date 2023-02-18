package com.github.morningwn.t1001_t1500.t1001_t1100.t1021_t1030;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T1021 {

    @Test
    public void test() {
        Out.println(removeOuterParentheses("(()())(())"));                //"()()()"
        Out.println(removeOuterParentheses("(()())(())(()(()))"));       //"()()()()(())"
        Out.println(removeOuterParentheses("()()"));                     //""

    }

    public String removeOuterParentheses(String S) {

        String result = "";
        int flg = 0;

        //同样是正确方法，写法不一样而已
/*        for ( int i = 0; i < S.length(); i++ ){
            if ( S.charAt(i) == '(' ){
                flg++;
                if ( flg > 1 )
                    result += S.charAt(i) + "";
            }else{
                if ( flg > 1 )
                    result += S.charAt(i) + "";
                flg--;
            }
        }*/

        //遍历字符串，根据flg标记的信息进行删除括号
        for (char i : S.toCharArray()) {

            //判断当前的字符是'('还是‘）’并根据结果进行不同的处理
            if (i == '(') {
                flg++;          //‘(’的话对flg进行加一

                //判断flg的值是否大于一，大于一的话就讲值存在结果集中
                if (flg > 1) {
                    result += i + "";
                }
            } else {
                //判断flg的值是否大于一，大于一的话就讲值存在结果集中
                if (flg > 1) {
                    result += i + "";
                }
                flg--;          //‘)’的话对flg进行减一
            }
        }

        return result;
    }
}
