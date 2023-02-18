package com.github.morningwn.t0001_t0500.t0301_t0400.t0351_t0360;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将数据流变为多个不相交区间
 *
 * @author moringwn
 * @date 2021/10/9 上午9:39
 */
public class T0352 {

    @Test
    public void test() {

//        ["SummaryRanges","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals"]
//[[],[6],[],[6],[],[0],[],[4],[],[8],[],[7],[],[6],[],[4],[],[7],[],[5],[]]

        SummaryRanges summaryRanges = new SummaryRanges();

        summaryRanges.addNum(1);
        sout(summaryRanges.getIntervals());

        summaryRanges.addNum(3);
        sout(summaryRanges.getIntervals());

        summaryRanges.addNum(7);
        sout(summaryRanges.getIntervals());

        summaryRanges.addNum(2);
        sout(summaryRanges.getIntervals());

        summaryRanges.addNum(6);
        sout(summaryRanges.getIntervals());
    }

    public void sout(int[][] arrays) {

        Out.println();
        for (int[] array : arrays) {
            Out.print(Arrays.toString(array) + ", ");
        }
        Out.println();

    }

    class SummaryRanges {
        private final List<int[]> list;

        public SummaryRanges() {
            list = new ArrayList<>();
        }

        public void addNum(int val) {
            int l = 0;
            int r = list.size();

            if (r == 0) {
                list.add(new int[]{val, val});
                return;
            }

            while (l < r) {
                int m = (l + r) / 2;
                if (list.get(m)[0] <= val && list.get(m)[1] >= val) {
                    break;
                } else if (list.get(m)[0] - 1 == val) {
                    list.get(m)[0] = val;

                    // 合并子区间
                    while (m - 1 >= 0 && (list.get(m - 1)[1] == val || list.get(m - 1)[1] == val - 1)) {
                        list.get(m)[0] = list.get(m - 1)[0];
                        list.remove(m - 1);
                        m--;
                    }
                    break;
                } else if (list.get(m)[1] + 1 == val) {
                    list.get(m)[1] = val;

                    // 合并相同区间
                    while (m + 1 < list.size() && (list.get(m + 1)[0] == val || list.get(m + 1)[0] == val + 1)) {
                        list.get(m)[1] = list.get(m + 1)[1];
                        list.remove(m + 1);
                    }
                    break;
                } else if (list.get(m)[0] > val) {
                    if (m - 1 < 0 || list.get(m - 1)[1] + 1 < val) {
                        list.add(m, new int[]{val, val});
                        break;
                    } else {
                        r = m;
                    }
                } else if (list.get(m)[1] < val) {
                    if (m + 1 >= list.size() || list.get(m + 1)[0] - 1 > val) {
                        list.add(m + 1, new int[]{val, val});
                        break;
                    } else {
                        l = m;
                    }
                } else {
                    list.add(new int[]{val, val});
                    break;
                }
            }
        }

        public int[][] getIntervals() {
            int[][] ints = new int[list.size()][2];

            for (int i = 0; i < list.size(); i++) {
                ints[i][0] = list.get(i)[0];
                ints[i][1] = list.get(i)[1];
            }

            return ints;
        }
    }
}


