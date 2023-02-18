package com.github.morningwn.t1001_t1500.t1201_t1300.t1231_t1240;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-positive-integer-solution-for-a-given-equation/">1237. 找出给定方程的正整数解</a>
 *
 * @author morningwn
 * @date Created in 2023/2/18 14:13
 */
public class T1237 {

    interface CustomFunction {
        public int f(int x, int y);
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> solutionList = new ArrayList<>();
        for (int x = 1, y = 1000; x < 1000 && y > 0; x++) {
            while (y > 0 && customfunction.f(x, y) > z) {
                y--;
            }
            if (customfunction.f(x, y) == z) {
                List<Integer> solution = new ArrayList<>();
                solution.add(x);
                solution.add(y);
                solutionList.add(solution);
            }
        }

        return solutionList;

    }
}