package com.github.morningwn.t0501_t1000.t0801_t0900.t0811_t0820;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/short-encoding-of-words/">820. 单词的压缩编码</a>
 *
 * @author morningwn
 * @date
 */
public class T0820 {

    @Test
    public void test() {
        String[] words = {"time", "me", "bell"};      //10
//        String[] words = { "time", "me", "bell", "lle" };      //14
//        String[] words = { "time", "me" };      //5
//        String[] words = { "time", "me", "sumetime" };      //9

//        for ( String word : words )
//            Out.println( word );

        Out.println(minimumLengthEncoding(words));
    }

    public int minimumLengthEncoding(String[] words) {

        StringBuilder sb = new StringBuilder();         //存储，编码

        for (int i = 0; i < words.length; i++) {

            //如果为空，代表已经处理过了，直接进入下一次循环
            if (words[i] == "") {
                continue;
            }

            String tmp = words[i];          //暂存，word[i]的值

            //查询第i个字符串是否已经在编码里面了
            //是就直接进行下一次循环
            if (sb.indexOf(tmp + "#") != -1) {
                words[i] = "";
                continue;
            }

            //查询剩余的字符里面有没有，包含word[i]
            for (int j = i + 1; j < words.length; j++) {

                int index = words[j].indexOf(tmp);
                if (index != -1 && (index + tmp.length()) == words[j].length()) {
                    tmp = words[j];
                    words[j] = "";
                }

            }
            words[i] = "";
            sb.append(tmp + "#");
        }

//        Out.println( sb.toString() );
        return sb.length();
    }

/*    //非最优解
    public int minimumLengthEncoding(String[] words) {

        StringBuilder sb = new StringBuilder();         //存储，编码
        List<String> list = new ArrayList<>(words.length);//存储，输入的字符串

        //将输入的字符串，填在list中，并去除重复的
        for ( String word : words ){
            if ( !list.contains( word ) )
                list.add( word );
        }

        //依次将list中的元素安排进编码表里面
        while ( list.size() > 0 ){

            String tmp = list.get(0);

            //如果tmp已经是编码的子串了，直接移除，进行下一次循环就行了
            //否则就，查询，然后添加
            if ( sb.indexOf( tmp+"#" ) != -1 ){
                list.remove( 0 );
            }else {
                list.remove( 0 );
                sb.append( addWord( tmp ,list )+"#" );
            }


        }

        return sb.length();

    }


    //递归查询整个序列中，包含，字符串word的，最长的字符串
    public String addWord( String word, List<String> list ){

        //从零开始
        int index = 0;

        //遍历整个字符串
        while ( list.size() > index ){

            String tmp = list.get( index );
            int i = tmp.indexOf( word );

            //如果字符串word是tmp的子串，就将字符串tmp从列表里面移除，进入下一次递归
            //否则，就将下下标加一
            if ( i != -1 && (i+word.length()) == tmp.length() ){
                list.remove(index);
                return addWord( tmp, list );
            }else
                index++;
        }

        return word;

    }*/

}
