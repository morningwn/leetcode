package com.github.morningwn.t0001_t0500.t0001_t0100.t0031_t0040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T0038 {

    @Test
    public void test() {

        for (int i = 1; i < 10; i++) {
            Out.println(countAndSay(i));
        }
    }

    //非递归
    public String countAndSay(int n) {

        String output = "1";

        //循环n-1次，输出结果
        for (int i = 1; i < n; i++) {

            String tmp = "";        //暂时存储这次循环中得到的字符串
            int count = 1;          //用于计数，接下来有几个相同的数字，默认为1

            //在这个信息中数上次的字符串里面的字符，生成结果
            for (int j = 0; j < output.length(); j++) {

                //查询接下来有几个相同的数字
                while (j + 1 < output.length() && output.charAt(j) == output.charAt(j + 1)) {
                    count++;
                    j++;
                }
//                Out.println( i + " \t " + j + "\t" + count + " \t " + tmp);

                //如果不是为1的话就证明有连续的数字，将结果存储后将count重新置1
                if (count != 1) {
                    tmp += count + "" + output.charAt(j - 1);
                    count = 1;
                } else {
                    tmp += "1" + output.charAt(j);
                }
            }

            //将本次循环的结果存储，用于下一次循环或者输出
            output = tmp;

//            Out.println( output + " \t" + i  );
        }

        return output;
    }

}
