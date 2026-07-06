package com.github.morningwn.t1001_t1500.t1201_t1300.t1281_t1290;

import com.github.morningwn.prefab.FormatInput;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/remove-covered-intervals">1288. 删除被覆盖区间</a>
 *
 * @author morningwn
 * @date 2026-07-06 15:24:00
 */
public class J1288 {

    @Test
    public void test() {
        Assert.assertEquals(4, removeCoveredIntervals(FormatInput.stringTo2Array(
                "[[51,77],[24,36],[41,46],[99,100],[95,96],[48,52],[31,89],[9,63],[65,85]]", 2)));
        Assert.assertEquals(1, removeCoveredIntervals(FormatInput.stringTo2Array(
                "[[201,216],[60,254],[36,383],[50,76],[320,376],[95,330],[361,375],[208,368],[84,112],[41,340]]", 2)));
        Assert.assertEquals(2, removeCoveredIntervals(FormatInput.stringTo2Array("[[1,4],[3,6],[2,8]]", 2)));
        Assert.assertEquals(2, removeCoveredIntervals(FormatInput.stringTo2Array("[[3,10],[4,10],[5,11]]", 2)));
    }

    private int[][] buildTest(int length, int max) {
        Random random = new Random();

        int[][] intervals = new int[length][2];
        for (int i = 0; i < length; i++) {
            intervals[i][0] = random.nextInt(max);
            intervals[i][1] = intervals[i][0] + random.nextInt(max - intervals[i][0]) + 1;
        }

        return intervals;
    }

    public int removeCoveredIntervals(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] interval : intervals) {
            Integer end = map.get(interval[0]);
            if (end != null && end < interval[1]) {
                map.put(interval[0], interval[1]);
            }
            Map.Entry<Integer, Integer> lowerEntry = map.lowerEntry(interval[0]);
            if (lowerEntry != null) {
                if (lowerEntry.getValue() >= interval[1]) {
                    continue;
                }
            }

            Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(interval[0]);
            while (ceilingEntry != null && ceilingEntry.getValue() <= interval[1]) {
                map.remove(ceilingEntry.getKey());
                ceilingEntry = map.ceilingEntry(interval[0]);
            }
            map.put(interval[0], interval[1]);
        }

        return map.size();
    }
}
