package com.github.morningwn.t0001_t0500.t0001_t0100.t0001_t0010;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/">5. 最长回文子串</a>
 *
 * @author morningwn
 * @date Created in 2020/5/21 16:19
 */
public class T0005 {

    @Test
    public void test() {
        Out.println(longestPalindrome1("bb"));
    }

    /**
     * 暴力循环，查询最长的字串
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {

        //存贮长度
        int length = s.length();

        //长度小于等于1的时候均可以直接返回结果
        if (length <= 1) {
            return s;
        }

        //用来存贮暂时切割得到的值
        String temp = "";

        //循环length次，切割得到的字符串的长度从length到1
        for (int i = 0; i < length; i++) {

            //切割i+1次，保证不会有漏掉的，长度每缩小1，切割得到的字符串就多一个，循环次数就加一
            for (int j = 0; j < i + 1; j++) {

                //得到切割后的字符串
                temp = s.substring(j, j + length - i);

                //判断字符串是否满足回文的条件
                for (int k = 0; k < temp.length(); k++) {

                    //不满足就跳出判断的循环，进行下一次的切割
                    if (temp.charAt(k) != temp.charAt(temp.length() - 1 - k)) {
                        break;
                    }

                    //因为是整型的除法计算，小数均舍去，所以不用担心奇偶的问题
                    //奇数循环(temp.length()-1)/2次，偶数循环temp.length()/2次即为满足条件的子串，返回结果
                    if (k == temp.length() / 2) {
                        return temp;
                    }
                }
            }

        }
        return "";

    }

}
