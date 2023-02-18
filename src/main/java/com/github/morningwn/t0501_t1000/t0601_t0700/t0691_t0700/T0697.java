package com.github.morningwn.t0501_t1000.t0601_t0700.t0691_t0700;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/degree-of-an-array/">697. 数组的度</a>
 *
 * @author morningwn
 * @date 2021/2/20 17:50
 */
public class T0697 {


    @Test
    public void test() {
//        int[] nums = {1, 2, 2, 3, 1}; // 2
//        int[] nums = {1,2,2,3,1,4,2}; // 6
//        int[] nums = {1,2, 3, 5, 4, 6}; // 1

        int[] nums = {1, 5, 2, 3, 5, 4, 5, 6}; // 6

        Out.println(findShortestSubArray(nums));
    }

    public int findShortestSubArray(int[] nums) {

        int max = 0;
        //存储度对应的数字
        List<Integer> maxNums = new ArrayList<>();

        //存储区间
        Map<Integer, int[]> intervals = new HashMap<>();
        //存储每个数字对应的数量
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            //更新区间
            int[] interval = intervals.getOrDefault(num, new int[]{i, i});
            interval[1] = i;
            intervals.put(num, interval);

            //更新数量
            int count = counts.getOrDefault(num, 0) + 1;
            counts.put(num, count);

            //对比得到度对应的数字
            if (count > max) {
                max = count;
                maxNums.clear();
                maxNums.add(num);
            } else if (count == max) {
                maxNums.add(num);
            }
        }

        int res = nums.length;

        //获取最小的区间
        for (int maxNum : maxNums) {
            int[] interval = intervals.get(maxNum);
            res = Math.min(res, interval[1] - interval[0]);
        }


        return res + 1;
    }
}
