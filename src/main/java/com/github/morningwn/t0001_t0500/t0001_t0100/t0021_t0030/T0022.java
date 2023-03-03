package com.github.morningwn.t0001_t0500.t0001_t0100.t0021_t0030;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/generate-parentheses/">22. 括号生成</a>
 *
 * @author morningwn
 * @date Created in
 */
public class T0022 {

    //来自大佬的最优解
    private final List<String> result = new ArrayList<String>();

    @Test
    public void test() {
        Out.println(generateParenthesis(3));
    }

    public void generate(String item, int left, int right) {
        //左括号和右括号满足上述条件的前提下都为n个，添加这个答案
        if (left == 0 && right == 0) {
            result.add(item);
            return;
        }
        //左括号的个数小于n 才能继续放左括号
        if (left > 0) {
            generate(item + "(", left - 1, right);
        }
        //左括号个数必须大于右括号的放置个数 才能继续放右括号
        if (left < right) {
            generate(item + ")", left, right - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        /**
         *左括号个数必须大于右括号的放置个数 才能继续放右括号
         *左括号的个数小于n 才能继续放左括号
         *左括号和右括号满足上述条件的前提下都为n个，添加这个答案
         */
        generate("", n, n);
        return result;
    }

/*
    //非最优解，但是勉强通过
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        //在通过循环得到不重复的长度为2n的二进制10串，和括号串对应，之后判断是否是合格的括号串
        for (int i = (int)Math.pow(2,2*n-1); i < Math.pow(2,2*n); i+=2 ){
            //将十进制的i转化为二进制的串，之后通过replaceAll方法转化为括号串
            String tmp = Integer.toString(i, 2).replaceAll("1", "(").replaceAll("0", ")");

            //通过判断将合法的存储在结果集中
            if ( isValid(tmp) )
                result.add( tmp );
        }

        return result;
    }

    //根据之前的一道题更改的判断算法，判断输入的括号串是否是符合规定的
    public boolean isValid(String s) {

        int stoke = 0;
        for ( char i : s.toCharArray() ){
            if ( i == '(' ){
                stoke++;
            }else {
                if (stoke == 0 )
                    return false;

                if ( i == ')'  ){
                    stoke--;
                }else
                    return false;
            }
        }
        return stoke==0;
    }
*/

/*
    //此法超时
    private List<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {

        //以“（）”为一个单位，进行循环，最后对每一个得到的结果进行判断是否重复
        donext( "()", n-1 );
        return result;
    }

    public static void donext(String str, int len){
        //在迭代结束后
        if ( len == 0 ){
            //如果在结果集中不重复就将其添加在结果集中
            if ( !result.contains(str) )
                result.add(str);
        //还可以继续进行循环
        }else{

            //进行循环，将“（）”插入不同的位置，之后进行下一次的迭代
            for( int i = 0; i < str.length(); i++ ){
                String tmp = str.substring(0, i )+"()"+str.substring(i);
                donext( tmp, len-1 );
            }
        }
    }
*/
}
