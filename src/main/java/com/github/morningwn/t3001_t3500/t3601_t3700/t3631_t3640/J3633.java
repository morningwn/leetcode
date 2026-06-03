package com.github.morningwn.t3001_t3500.t3601_t3700.t3631_t3640;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/earliest-finish-time-for-land-and-water-rides-i">3633. 最早完成陆地和水上游乐设施的时间 I</a>
 *
 * @author morningwn
 * @date 2026-06-03 15:00
 */
public class J3633 {

    @Test
    public void test1() {
        int[] landStartTime = {99};
        int[] landDuration = {59};
        int[] waterStartTime = {99, 54};
        int[] waterDuration = {85, 20};

        int finishTime = earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        Assert.assertEquals(158, finishTime);
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                if (landStartTime[i] + landDuration[i] >= waterStartTime[j]) {
                    res = Math.min(res, landStartTime[i] + landDuration[i] + waterDuration[j]);
                } else {
                    res = Math.min(res, waterStartTime[j] + waterDuration[j]);
                }
            }
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            for (int j = 0; j < landStartTime.length; j++) {
                if (waterStartTime[i] + waterDuration[i] >= landStartTime[j]) {
                    res = Math.min(res, waterStartTime[i] + waterDuration[i] + landDuration[j]);
                } else {
                    res = Math.min(res, landStartTime[j] + landDuration[j]);
                }
            }
        }

        return res;
    }
}
