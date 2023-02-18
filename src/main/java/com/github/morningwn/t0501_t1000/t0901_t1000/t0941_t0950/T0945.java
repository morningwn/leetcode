package com.github.morningwn.t0501_t1000.t0901_t1000.t0941_t0950;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;


public class T0945 {

    @Test
    public void test() {

//        int[] A = { 1,2,2 };            //1
        int[] A = {1, 1};            //1
//        int[] A = { 3,2,1,2,1,7 };            //6

        Out.println(minIncrementForUnique(A));
    }

    public int minIncrementForUnique(int[] A) {

        int count = 0;

        Arrays.sort(A);

        int i = 1;
        while (i < A.length) {

//            for ( int a : A )
//                Out.print( a +"\t ");
//            Out.println( "i:"+ i + "\t count:"+ count );
            if (A[i - 1] >= A[i]) {
                A[i]++;
                count++;
            } else {
                i++;
            }
        }

        return count;

    }

}
