package com.github.morningwn.t0001_t0500.t0101_t0200.t0111_t0120;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningwn
 * @description: 杨辉三角
 * @date Created in 2020/6/1 10:24
 * @version: 1.0
 */
public class T0118 {
    public T0118() {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        if (numRows > 0) {
            res.add(new ArrayList<Integer>() {{
                add(1);
            }});
        } else {
            return res;
        }


        for (int i = 1; i < numRows; i++) {
            List<Integer> bf = res.get(i - 1);
            List<Integer> tmp = new ArrayList<>(i + 1);
            tmp.add(1);
            for (int j = 1; j < bf.size(); j++) {
                tmp.add(bf.get(j - 1) + bf.get(j));
            }
            tmp.add(1);
            res.add(tmp);
        }

        return res;
    }

    public void test() {

    }
}
