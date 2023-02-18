package com.github.morningwn.t1001_t1500.t1401_t1500.t1441_t1450;

/**
 * <a href="https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/">1450. 在既定时间做作业的学生人数</a>
 *
 * @author morningwn
 * @create in 2022/8/19 9:36
 */
public class T1450 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;

        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                ++count;
            }
        }

        return count;
    }
}
