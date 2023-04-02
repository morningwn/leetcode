package com.github.morningwn.t1001_t1500.t1001_t1100.t1031_t1040;

/**
 * <a href="https://leetcode.cn/problems/valid-boomerang/">1037. 有效的回旋镖</a>
 *
 * @author moringwn
 * @create in 2022/6/8 10:58
 */
public class T1037 {

    public boolean isBoomerang(int[][] points) {
        return (points[0][0] - points[1][0]) * (points[0][1] - points[2][1]) - (points[0][0] - points[2][0]) * (points[0][1] - points[1][1]) != 0;
    }
}
