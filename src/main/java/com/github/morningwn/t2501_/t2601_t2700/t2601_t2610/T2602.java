package com.github.morningwn.t2501_.t2601_t2700.t2601_t2610;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-make-all-array-elements-equal/">2602. 使数组元素全部相等的最少操作次数</a>
 *
 * @author morningwn
 * @create in 2023/4/1 10:12
 */
public class T2602 {

    @Test
    public void test() {
        int[] nums = {3, 1, 6, 8};
        int[] queries = {0, 5};
        List<Long> minOperations = minOperations(nums, queries);
        Out.println(minOperations);
    }

    public List<Long> minOperations(int[] nums, int[] queries) {
        int length = nums.length;
        List<Long> operations = new ArrayList<>(queries.length);
        Arrays.sort(nums);

        long sum = 0L;
        TreeMap<Integer, long[]> treeMap = new TreeMap<>();

        for (int i = 0; i < length; i++) {
            sum += nums[i];
            treeMap.put(nums[i], new long[]{sum, i + 1});
        }

        for (int query : queries) {
            // 自己手写的话这个地方可以使用二分查询
            Map.Entry<Integer, long[]> entry = treeMap.floorEntry(query);
            long operation = 0;
            if (entry != null) {
                operation = entry.getValue()[1] * query - entry.getValue()[0] + (sum - entry.getValue()[0]) - (length - entry.getValue()[1]) * query;
            } else {
                operation = sum - (long) length * query;
            }
            operations.add(operation);
        }

        return operations;
    }
}
