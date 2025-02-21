package com.github.morningwn.t2001_t2500.t2201_t2300.t2201_t2210;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.*;

/**
 * <a hrerf="https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/">2208. 将数组和减半的最少操作次数</a>
 *
 * @author morningwn
 * @create in 2023/1/31 23:35
 */
public class J2208 {

    @Test
    public void test() {
        int[] nums = {5, 19, 8, 1};

        List<Double> list = new ArrayList<>();
        list.add(19.0);
        list.add(8.0);
        list.add(5.0);
        list.add(1.0);
        //sort(list, 21.0);

        //System.out.println(list);
        Out.println(halveArray(nums));
    }

    public int halveArray(int[] nums) {
        System.out.println(nums.length);
        if (nums.length == 1) {
            return 1;
        }
        double originSum = 0;
        PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.comparingDouble(d -> -d));

        for (int i = nums.length - 1; i > -1; i--) {
            queue.offer((double) nums[i]);
            originSum += nums[i];
        }
        int count = 0;
        double curSum = originSum;
        double targetSum = originSum / 2.0;
        while (curSum > targetSum) {
            Double tmp = queue.poll();
            curSum -= tmp / 2.0;
            queue.offer(tmp / 2.0);
            count++;
        }

        return count;
    }

}
