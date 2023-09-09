package com.github.morningwn.t2501_.t2601_t2700.t2651_t2660;

/**
 * <a href="https://leetcode.cn/problems/calculate-delayed-arrival-time/">2651. 计算列车到站时间</a>
 *
 * @author morningwn
 * @date Created in 2023/9/8 22:06
 */
public class T2651 {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

}
