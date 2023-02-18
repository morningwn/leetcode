package com.github.morningwn.t0501_t1000.t0701_t0800.t0791_t0800;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class T0792 {

    @Test
    public void test() {

        String[] words = {"a", "bb", "acd", "ace"};

        Out.println(numMatchingSubseq("abcde", words));
    }

    public int numMatchingSubseq(String S, String[] words) {

        //以下两个list分别用来存储子串，非子串，用来进行判断
        List<String> dirCon = new ArrayList<String>();
        List<String> dirUncon = new ArrayList<String>();

        //存储符合规则的字符串个数
        int count = 0;

        //遍历整个数组，得到结果
        for (String str : words) {

            //首先进行判断，在之前是否已经存在相同的子串
            //判断是否是之前已经存在的通过的
            if (dirCon.contains(str)) {
                count++;
                //判断是否是之前已经存在的，未通过的
            } else if (dirUncon.contains(str)) {
                continue;
                //如果不存在相同子串在进行下一步的判断
                //首先进行整体判断，字符串S中是否包含str
            } else if (S.contains(str)) {
                count++;
                dirCon.add(str);        //将通过判断的字符串添加在已经通过的结果集中，方便之后的进行判断
                //再进行单个的判断
            } else {
                //两个指针分别指向S和str的单个字符
                int i = 0, j = 0;

                //循环直到S或者str尾部
                while (i < S.length() && j < str.length()) {

                    //判断S是否存在当前指向的str的单个字符，不存在就直接结束循环
                    if (S.contains(str.charAt(j) + "")) {

                        //如果S当前指向字符和str当前指向字符相同就将指针后移一位
                        if (S.charAt(i) == str.charAt(j)) {
                            j++;
                        }

                        i++;
                    } else {
                        break;
                    }
                }

                //判断str是否已经全部被遍历
                //若是就将count加一并将其添加在dirCon中
                //否就将其添加在dirUncon中
                if (j == str.length()) {
                    count++;
                    dirCon.add(str);
                } else {
                    dirUncon.add(str);
                }
            }


//            Out.println( str + "\t " + j +"\t"+count );
        }

        return count;
    }

}
