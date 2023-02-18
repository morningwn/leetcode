package com.github.morningwn.t1001_t1500.t1201_t1300.t1281_t1290;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer/">1281. 整数的各位积和之差</a>
 *
 * @author moringwn
 * @date
 */
public class T1281 {

    @Test
    public void test() {

        Out.println(subtractProductAndSum(234));        //15
        Out.println(subtractProductAndSum(4));        //0
        Out.println(subtractProductAndSum(23));        //1
        Out.println(subtractProductAndSum(0));        //0
        Out.println(subtractProductAndSum(705));        //-12
        Out.println(subtractProductAndSum(70));        //-7
    }

    public int subtractProductAndSum(int n) {

        if (n == 0) {
            return 0;
        }

        int sum = 0;
        int acc = 1;

        int num = n;
        int next = num % 10;
        //Out.println( "next:"+next + "\t sum:" + sum + "\t acc:" + acc);


        while (num != 0) {

            //Out.println( "next:"+next + "\t sum:" + sum + "\t acc:" + acc);
            sum += next;
            acc *= next;

            num = num / 10;
            next = num % 10;
        }

        return acc - sum;
    }
}
