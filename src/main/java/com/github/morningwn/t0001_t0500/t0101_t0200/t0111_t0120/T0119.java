package com.github.morningwn.t0001_t0500.t0101_t0200.t0111_t0120;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningwn
 * @description: 杨辉三角 II
 * @date Created in 2020/6/1 10:42
 * @version: 1.0
 */
public class T0119 {

    @Test
    public void test() {
        Out.println(getRow(2));
        Out.println(getRow(3));
        Out.println(getRow(4));
        Out.println(getRow(5));

    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);


        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> tmp = new ArrayList<Integer>(i + 1);
            tmp.add(1);


//            for (int j = 1; j < row.size(); j++) {
//                tmp.add(row.get(j-1)+row.get(j));
//            }

            int half = (row.size() + 1) / 2;

            for (int j = 1; j < half; j++) {
                int t = row.get(j - 1) + row.get(j);
                tmp.add(j, t);
                tmp.add(j, t);
            }
            tmp.add(1);

            if ((row.size() + 1) % 2 != 0) {
                tmp.add(half, row.get(half - 1) + row.get(half));
            }


//            int half = (row.size()+1)/2 + ((row.size()+1)%2 == 0 ? 0 : 1);
//
//            for (int j = 1; j < half; j++) {
//                tmp.add(row.get(j-1)+row.get(j));
//            }
////            Out.println(tmp + "\t " + half);
//            half = (row.size()+1)/2;
//            for (int j = 1; j < half; j++) {
//                tmp.add(tmp.get(half-j));
//            }
            row = tmp;
        }

        return row;
    }

}
