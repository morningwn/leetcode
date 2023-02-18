package com.github.morningwn.t0001_t0500.t0001_t0100.t0051_t0060;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningwn
 * @description: 合并区间
 * @date Created in 2020/4/16 17:39
 * @version: 1.0
 */
public class T0056 {

    @Test
    public void test() {
        //[[1,6],[8,10],[15,18]]
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        //[[1,5]]
//        int[][] intervals = {{1,4},{4,5}};

//        //[[1,10]]
//        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};

        for (int[] r : merge(intervals)) {
            Out.println(r[0] + "\t " + r[1]);
        }
    }

    public int[][] merge(int[][] intervals) {

        //handling special cases
        if (intervals.length <= 1) {
            return intervals;
        }

        //store result
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        //travers the interval
        for (int i = 1; i < intervals.length; i++) {

            //store the insertion point
            int index = res.size() - 1;

            //find the insertion point
            //compare each value in the res. if it is smaller, decrease the index
            while (index >= 0) {
                if (res.get(index)[0] < intervals[i][0]) {
                    break;
                } else {
                    index--;
                }
            }

            //mark whether the values need to be inserted
            boolean insert = false;

            //compare whether the value before the insertion point can be merged
            //if it can be merged, this means no need to insert
            if (index >= 0 && res.get(index)[1] >= intervals[i][0]) {
                res.get(index)[1] = Math.max(res.get(index)[1], intervals[i][1]);
                insert = true;
            }

            //insert value based on the tag
            if (!insert) {
                index++;
                res.add(index, intervals[i]);
            }

            //compare whether the value after the insertion point can be merged.
            //if it can be merged, then delete the value before the merge
            //because we do not know how many times we can marge, we need loop
            while (index + 1 < res.size() && res.get(index)[1] >= res.get(index + 1)[0]) {
                res.get(index)[1] = Math.max(res.get(index)[1], res.get(index + 1)[1]);
                res.remove(index + 1);
            }
        }

        //convert the result to an array and return the array
        return res.toArray(new int[res.size()][]);

    }

}
